<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		vue => 라이브러리 (자바스크립트)
				vue / react => 상태 관리하는 프로그램
				               ------- 데이터 관리
				               
		1) 생명주기 => CallBack => vue시스템에서 자동 호출
		   beforeCreate() : 객체 생성전
		   	                Vue.createApp({
		   	                  데이터 관리
		   	                  데이터 처리
		   	                })
		   created() : 객체 생성
		   beforeMount() : window.onload => 화면 출력 전
		   mounted() : 화면 출력된 상태
		   beforeUpdate() : 수정전
		   updated() : 수정후
		   beforeDestroy() : 화면 변경 => 소멸전 
		   destroyed() : 소멸
		   
		   형식)
		       <html>
		         <div ...> => 2. view
		       </html>
		       Vue.createApp({
		          Model
		       	  1. data(){
		       	  	return {
		       	  	  관리할 데이터 설정
		       	  	}
		       	  }
		       ---------------------- 데이터 제어 VM
		       	 3. mounted(){}
		       	    methods:{
		       	    
		       	    }
		       	 4. components{
		       	 
		       	    }
		       	 5. computed:{
		       	 
		       	    }
		       	--------------------- MVVM- 
		       })
		2) 동작방법
		3) 디렉티브
		
		DOM / 가상 DOM
		                                   diff
		      ------- Vue => 가상메모리에 저장 <====> 실제 메모리
		                          |                  |
		                         작업               브라우저 연결
	 	양방향 : 사용자 입력 == 저장 데이터가 동시에 처리
	 	=> 제어하는 속성 : ref
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script> <!-- CDN 방식 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
  margin-top: 50px;
}
.row {
  margin:0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row" id="a">
      <h1>{{msg}}</h1>
    </div>
    <div class="row" id="b">
      <h1 @click="h1Click()">{{msg}}</h1>
      <img :src="img" style="width: 200px;height: 100px;">
    </div>
  </div>
  <script>
    // 전체 제어
    let con=Vue.createApp({
    	// 관리할 데이터 설정
    	data(){
    		return {
    			msg:'A Hello Vue3!!'
    		}
    	}
    }).mount('#a')
    
     let b=Vue.createApp({
    	// 관리할 데이터 설정
    	data(){
    		return {
    			msg:'B Hello Vue3!!',
    			img:'https://cdn.cgv.co.kr/cgvpomsfilm/Movie/Thumbnail/Poster/030000/30000286/30000286_320.jpg'
    		}
    	},
    	// VM
    	methods:{
    		h1Click(){
    			this.img="https://cdn.cgv.co.kr/cgvpomsfilm/Movie/Thumbnail/StillCut/030000/30000286/30000286403636_727.jpg"
    		}
    	}
    }).mount('#b')
  </script>
</body>
</html>