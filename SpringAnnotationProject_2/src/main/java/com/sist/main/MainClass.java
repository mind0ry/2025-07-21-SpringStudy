package com.sist.main;
/*
 * 	vo => mapper(SQL) => DAO => Service => MainClass호출
 *  ---------------------------------------------------
 *  | 클래스 관계도 : application-*.xml
 *                ------------------ 자바
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.*;
import com.sist.vo.*;
public class MainClass {
	public static void main(String[] args) {
		// 1. XML 파싱 => MVC는 자동 파싱
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		StudentService ss=(StudentService)app.getBean("service");
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("====== 메뉴 ======");
			System.out.println("1. 목록");
			System.out.println("2. 상세보기");
			System.out.println("3. 학생 등록");
			System.out.println("4. 학생 수정");
			System.out.println("5. 학생 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.println("=================");
			System.out.print("메뉴 선택:");
			int menu=scan.nextInt();
			
			switch(menu) {
			
				case 6: 
					System.out.println("프로그램을 종료합니다");
					System.exit(0);
				break;
				
				case 1: {
					List<StudentVO> list=ss.studentListData();
					if(list.size()==0) {
						System.out.println("등록된 학생이 없습니다!!");
					} else {
						for(StudentVO vo:list) {
							System.out.println(vo.getHakbun()+" "
									+vo.getName()+" "
									+vo.getKor()+" "
									+vo.getEng()+" "
									+vo.getMath());
						}
					}
				}
				break;
				
				case 3: {
					System.out.print("이름 입력:");
					String name=scan.next();
					System.out.print("국어 입력:");
					int kor=scan.nextInt();
					System.out.print("영어 입력:");
					int eng=scan.nextInt();
					System.out.print("수학 입력:");
					int math=scan.nextInt();
					
					StudentVO vo=new StudentVO();
					vo.setName(name);
					vo.setKor(kor);
					vo.setEng(eng);
					vo.setMath(math);
					
					ss.studentInsert(vo);
					System.out.println("학생 등록 완료!!");
				}
				break;
				
				case 2: {
					System.out.print("학번 입력:");
					int hakbun=scan.nextInt();
					StudentVO vo=ss.studentDetailData(hakbun);
					System.out.println("====== 학생 정보 ======");
					System.out.println("학번:"+vo.getHakbun());
					System.out.println("이름:"+vo.getName());
					System.out.println("국어:"+vo.getKor());
					System.out.println("영어:"+vo.getEng());
					System.out.println("수학:"+vo.getMath());
					int total=vo.getKor()+vo.getEng()+vo.getMath();
					System.out.println("총점:"+total);
					double avg=total/3.0;
					System.out.printf("평균:%.2f\n",avg);
				}
				break;
				
				case 4: {
					System.out.print("수정할 학번 입력:");
					int hakbun=scan.nextInt();
					
					System.out.print("국어 입력:");
					int kor=scan.nextInt();
					System.out.print("영어 입력:");
					int eng=scan.nextInt();
					System.out.print("수학 입력:");
					int math=scan.nextInt();
					
					StudentVO vo=new StudentVO();
					vo.setHakbun(hakbun);
					vo.setKor(kor);
					vo.setEng(eng);
					vo.setMath(math);
					
					ss.studentUpdate(vo);
					
					System.out.println("수정 완료되었습니다");
				}	
				break;
				
				case 5: {
					System.out.print("삭제할 학번 입력:");
					int hakbun=scan.nextInt();
					ss.studentDelete(hakbun);
					System.out.println("삭제 완료되었습니다");
				}	
				break;
			}
		}
	}
}
