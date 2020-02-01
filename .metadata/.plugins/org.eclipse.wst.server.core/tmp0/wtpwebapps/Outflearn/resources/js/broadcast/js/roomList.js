$(function () {

    // var socket = io.connect('https://localhost:3000');
    // var socket = io.connect('https://192.168.10.139:3000', { rejectUnauthorized: false });
    // var socket = io.connect('http://192.168.10.139:3000');


    socket.emit('bringRoom')

    socket.on('getRoom', function (msg) {

        var sendData = []

        msg.forEach(item => {
            sendData.push(item.room)
        });

        if (sendData[0]) {
            $.ajax({
                url: `liveRooms?liveRooms=${sendData}`,
                success: function (data) {
                    var content = '';
                    data.forEach(item => {
                        content +=
                            `
                        <div class="card">
                            <div>
                                <a href="joinLive?room=${item.class_num}">
                                    <img src="/Outflearn/resources/uploadImage/${item.class_img}" alt="what?">
                                    <div class="card-body">
                                        <h5 class="card-title">${item.class_title}</h5>
                                        <p class="card-text">${item.class_intro}</p>
                                    </div>
                                </a>
                            </div>
                        </div>
                        `
                    });
                    // <h3><a href='joinLive?room=${item.class_num}'>${item.class_title}</a></h3>

                    $('.roomTest').html(content)
                },
                error: function (err) {
                    console.log(err);
                }
            })
        } else {
            $('.roomTest').html(`<h3>방 없다!</h3>`)
        }
    })

    $('.reloadRoom').on('click', function () {
        socket.emit('bringRoom')
    })

})