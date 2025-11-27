<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script type="text/javascript" src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
.row {
  margin: 0px auto;
  width:960px;
}
p {
 overflow: hidden;
 white-space: nowrap;
 text-overflow: ellipsis;
}
.link{
  cursor:pointer;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
       <div class="col-md-3" v-for="vo in recipe_list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="vo.poster" style="width:230px;height: 120px"
		          :title="vo.title"
		        >
		        <div class="caption">
		          <p>{{vo.chef}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </div>
    <div class="row text-center" style="margin-top: 20px">
	  <ul class="pagination">
	  
	  
	    <li v-if="startPage>1"><a class="link" @click="prev(startPage-1)">&lt;</a></li>
	    
	    
	    <li v-for="i in range(startPage,endPage)" :class="i==curpage?'active':''" @click="pageChange(i)"><a class="link">{{i}}</a></li>
	    
	    
	    <li v-if="endPage<totalpage"><a class="link" @click="next(endPage+1)">&gt;</a></li>
	    
	    
	  </ul>
  </div> 

  </div>
  <script>
   let listApp=Vue.createApp({
	   data(){
		   return {
			   curpage:1,
			   totalpage:0,
			   startPage:0,
			   endPage:0,
			   recipe_list:[]
		   }
	   },
	   /*
	      map.put("curpage", curpage);
	      map.put("totalpage", totalpage);
	      map.put("startPage", startPage);
	      map.put("endPage", endPage);
	      map.put("list", list);
	   */
	   mounted(){
		 	this.dataRecv()
	   },
	   methods:{
		 range(start,end){
			 let arr=[];
			 let len=end-start
			 for(let i=0;i<=len;i++)
			 {
				 arr[i]=start
				 start++
			 }
			 return arr
		 },
		 prev(page){
			 this.curpage=page
			 this.dataRecv()
		 },
		 next(page){
			 this.curpage=page
			 this.dataRecv()
		 },
		 pageChange(page) {
			 this.curpage=page
			 this.dataRecv()
		 },
		 dataRecv() {
			 axios.get('list_vue.do',{
				 params:{
					 page:this.curpage
				 }
			 }).then(response=>{
				 console.log(response.data)
				 this.recipe_list=response.data.list
				 this.curpage=response.data.curpage
				 this.totalpage=response.data.totalpage
				 this.startPage=response.data.startPage
				 this.endPage=response.data.endPage
			 })
		 }
	   }
   }).mount(".container")
  </script>
</body>
</html>