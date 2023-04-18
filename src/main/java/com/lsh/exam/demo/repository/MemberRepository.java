package com.lsh.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lsh.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {

	@Insert("""
			INSERT INTO `member`
			SET regDate = NOW(),
			updateDate = NOW(),
			loginId = #{loginId},
			loginPw = #{loginPw},
			`name` = #{name},
			nickname = #{nickname},
			cellphoneNo = #{cellphoneNo},
			email = #{email};
			""")
	public void join(@Param("loginId")String loginId,@Param("loginPw") String loginPw,@Param("name") String name, @Param("nickname")String nickname, @Param("email")String email, @Param("cellphoneNo")String cellphoneNo);
	
	@Select("""
			SELECT * 
			FROM `member`
			ORDER BY 
			id DESC
			""")
	public List<Member> getMembers();

	@Select("SELECT LAST_INSERT_ID()")
	public int getLastInsertId();

	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.id = #{id}
			""")
	public Member getMemberById(@Param("id")int id);
	
	
	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.loginId = #{loginId}
			""")
	public Member getMemberByLoginId(@Param("loginId")String loginId);

	
	@Select("""
			SELECT *
			FROM `member` AS M
			WHERE M.name = #{name}
			OR M.email = #{email}
			""")
	public Member getMemberByNameAndEmail(@Param("name")String name,@Param("email") String email);
	
	

}
