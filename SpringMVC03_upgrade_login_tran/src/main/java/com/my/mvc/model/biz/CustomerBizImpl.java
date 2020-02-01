package com.my.mvc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.mvc.dto.CustomerDto;
import com.my.mvc.model.dao.CustomerDao;

@Service
public class CustomerBizImpl implements CustomerBiz {
	
	@Autowired
	private CustomerDao dao;

	@Override
	public List<CustomerDto> selectList() {
		
		return dao.selectList();
	}

	@Override
	public CustomerDto selectOne(String id) {
		
		return dao.selectOne(id);
	}

	@Override
	public int insert(CustomerDto dto) {
	
		return dao.insert(dto);
	}

	@Override
	public int update(CustomerDto dto) {
		
		return dao.update(dto);
	}

	@Override
	public int delete(String id) {
				return dao.delete(id);
	}

	@Override
	public int multidelete(String[] chk) {
	
		return dao.multidelete(chk);
	}

	@Override
	public CustomerDto login(String id, String pw) {
		
		return dao.login(id, pw);
	}

	@Override
	@Transactional
	public String test() {
		
		dao.insert(new CustomerDto("2", "2", "2"));
		String test = dao.test();
		
		test.length();		
		
		
		
		
		return test;
	}

}





/*
 *비즈에서 dao 여러개 호출해야할 때
 * @Transactional(tx:)
 * -isolation : 별도로 정의하지않으면 DB의 isolation level을 따른다
 * (isolation level)
 *   =default : 데이터베이스에 의존
 *   =uncommitted : commit되지않은 데이터를 볼 수 있다
 *   =committed : commit 된 데이터만 볼 수 있다
 *   =repeatable : 새로운 데이터 입력 시 볼 수 있다
 *   =serializable : 동일한 데이터에 동시에 두 개 이상의 트랜잭션이 수행 될 수 없다
 *   
 * -propagation : 전파규칙 정의(기본값: required)
 *   = required : 기존 트랜잭션이 존재하면 지원, 없으면 새로운 트랜잭션 시작
 *   = supports : 기존 트랜잭션이 존재하면 지원, 없으면 트랜잭션 없이,
 *   = mandatory : 반드시 트랜잭션 내에서 메소드 실행, 없으면 예외 발생
 *   = requeired_new : 언제나 새로운 트랜잭션 내에서 메소드 실행. 없으면 예외발생
 *   = not_supported : 기존 트랜잭션 내에서 실행. 없으면 트랜잭션 없이,
 *   = never : mandatory와 반대(반드시 트랜잭션 외에서)
 *   = nested : 트랜잭션이 존재하면 중첩되어 실행, 없으면 새로운 트랜잭션 시작
 *   
 * -readyonly : 읽기전용
 * -rollbackFor : 정의된 exception에 대해서 rollback수행
 * (ex: rollbackFor = Exception.class)
 * -norollbackFor : 정의된 Exception에 대해서 rollback수행안함
 * -timeout : 지정한 시간 내에 메소드 수행이 완료되지않으면 rollback
 * (기본값: -1 // no timeout)
 * mybatis 에서 timeout 존재하면 중첩되어 실행. 새로운 트랜젝션 시작  
 * 
 */
