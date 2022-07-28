<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<!-- Ajax(비동기처리방식) -->
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	<script>
	
		let i = 0;
		let xhtp = new XMLHttpRequest(); // 비동기방식 처리
		xhtp.open('get', 'dataList.txt');
		xhtp.send();
		xhtp.onreadystatechange = callBackThree;
		
	
		
		
		
		function callBackOne() {
			if(this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText);
				console.log(data);
				let name = document.createElement('p');
				name.innerText = data.name;
				let age = document.createElement('p');
				age.innerText = data.age;
				document.querySelector('body').append(name, age);
			};
		}
		
		function callBackTwo() {
			if(this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText);
				console.log(data);
				
				let ul = document.createElement('ul');
				for(let obj of data) {
					let li = document.createElement('li');
					li.innerHTML = obj.name + ', ' + obj.age; // <li> hong, 15 </li>
					ul.append(li);
				}
				console.log(ul);
				document.querySelector('body').append(ul);
		}
		}
		
		function callBackThree() {
			if(this.readyState == 4 && this.status == 200) {
				let data = JSON.parse(this.responseText);
				console.log(data);
				let tbody = document.getElementById('list');	
				
				// 데이터건수 반복
				for(let obj of data) {
					let tr = document.createElement('tr');
					// 필드 개수만큼 반복
					for(let field in obj ) {
						let td = document.createElement('td');
						td.innerText = obj[field];
						tr.append(td);
					}
				tbody.append(tr);
				}
				}
		}
	</script>
</body>
</html>