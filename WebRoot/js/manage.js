window.onload = function() {
	var xmlhttp = new XMLHttpRequest();
	var result;
	var idTmp;
	xmlhttp.open("GET", "http://localhost:8080/food/manage", true);
	xmlhttp.send(null);
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState == 4) {
			if(xmlhttp.status == 200) {
				result = xmlhttp.responseText;
				setContent(result);
			}
		}
	};

	function setContent(result) {
		var per = JSON.parse(result);
		var tbody = document.getElementById('tbMain');
		//遍历json数据
		for(var i = 0; i < per.length; i++) { 
	        var trow = getDataRow(per[i]);
	        tbody.appendChild(trow);
	    }
	};

	//创建表格
	function getDataRow(h) {
		var row = document.createElement('tr');
		var idCell = document.createElement('td');
		idCell.innerHTML = h.id;
		row.appendChild(idCell);
		var usernameCell = document.createElement('td');
		usernameCell.innerHTML = h.username;
		row.appendChild(usernameCell);
		var foodnameCell = document.createElement('td');
		foodnameCell.innerHTML = h.foodname;
		row.appendChild(foodnameCell);
		var foodnumberCell = document.createElement('td'); 
		foodnumberCell.innerHTML = h.foodnumber;
		row.appendChild(foodnumberCell);
		var foodpriceCell = document.createElement('td');
		foodpriceCell.innerHTML = h.foodprice;
		row.appendChild(foodpriceCell);
		var orderstatusCell = document.createElement('td');
		orderstatusCell.innerHTML = h.status;
		row.appendChild(orderstatusCell);
		//添加按钮
		var uptCell = document.createElement('td');
		row.appendChild(uptCell);
		var btnUpt = document.createElement('input');
		btnUpt.setAttribute('type','button');
		btnUpt.setAttribute('value','完成订单');
		
		btnUpt.onclick=function(){
			var stat = btnUpt.parentNode.previousSibling.innerText;
			if(stat=='complete') {
				btnUpt.disable = true;
				} else {
					idTmp = this.parentNode.parentNode.firstChild.innerText;
					if(confirm("确定完成"+ idTmp + "号订单?" )) {
						postNewStatus(idTmp);
					}
				}			
		};
		uptCell.appendChild(btnUpt);
		return row;
	}

	//post新状态
	function postNewStatus(idTmp) {
		xmlhttp.open("POST", "http://localhost:8080/food/manage", true);
		xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlhttp.send("id="+idTmp);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				if (xmlhttp.status == 200) {
					var result = xmlhttp.responseText;
					if (result == "success") {
						alert("success");
					} else if (result == "failed") {
						alert("failed");
					}
					location.reload();
				}
			}
		};
	}
};