window.addEventListener("load", function() {

	const menuList = document.querySelector(".menu-list");
	let ul = document.querySelector(".menu-category>ul");
	
	const form =document.querySelector(".search-header form");
	const findButton = form.querySelector(".icon-find");
	console.log(findButton);
	
	findButton.onclick =function(e){
		e.preventDefault();
		
		const queryInput = form.querySelector("input[name=q]");
		let query = queryInput.value;
		
		
		const request = new XMLHttpRequest();
		request.onload = function() {
			let menus = JSON.parse(request.responseText);
			bind(menus);
			
		}
		//`백틱=템플릿 문자열. 데이터 꽂기위해
		request.open("GET", `http://localhost:8080/menus?q=${query}`, true);//브라우저에서 url을 입력하는 것과 같은 요청정보 입력
		request.send();
		
	}


	//			
	//	//=======Fetch API===========
	//		
	//		var requestOptions = {
	//		  method: 'GET',
	//		  redirect: 'follow'
	//		};
	//
	//		fetch("http://localhost:8080/menus/617", requestOptions)
	//		  .then(response => response.text())
	//		  .then(result => console.log(result))
	//		  .catch(error => console.log('error', error));
	//	
	//		
	//	
	//		
	//	//========XHR(XmlHttpRequest)==========
	//	var xhr = new XMLHttpRequest();
	//		xhr.withCredentials = true;
	//		
	//		xhr.addEventListener("readystatechange", function() {
	//		  if(this.readyState === 4) {
	//	    console.log(this.responseText);
	//	  }
	//	});
	//
	//		xhr.open("GET", "http://localhost:8080/menus/617");
	//		
	//		xhr.send();
	
	
		
	ul.onclick = function(e) {
		e.preventDefault();
		let tagName = e.target.tagName;

		// if(tagName == 'LI' || tageName == 'A') 같은것
		if (tagName != 'LI' && tagName != 'A') //li가 아니면 return해. 단,태그이름이 대문자여야함
			return;

		//데이터 수집을 해야함.
		//클릭해서 리스트 얻어내는 작업
		let elLi = (tagName === 'LI') ? e.target : e.target.parentNode;
		//elLi.className="menu-selected";
		
		
		let curLi= ul.querySelector("li.menu-selected");
		
		//기존에 있는애 찾을때 포문돌리지마 셀렉트면 끝나. 
		
		if(curLi === elLi){
			return;
		};
			elLi.classList.add("menu-selected");
			curLi.classList.remove("menu-selected");
		
		console.log(elLi.dataset.cid);

		let categoryId = (elLi.dataset.cid);
		

		//원격에서 데이터를 가져온다
		const request = new XMLHttpRequest();
		//브라우저에서 url을 가입력하는 것과 같은 요청정보 입력 false=비동기가 아니다. true=동기
		//콜백함수= 이따(비동기작업이 완료되면)호출해죠 이런방식을 쓰는게 xhml
		request.onload = function() {
			let menus = JSON.parse(request.responseText);
			bind(menus);
		};
		request.open("GET", `http://localhost:8080/menus?c=${categoryId}`, true); // true 비동기로 하겠다는 뜻 
		request.send();
};
/*
			//기존 목록을 모두 지우고

			//menuList.children[0].remove();
			//menuList.removeChild(menuList.firstElementChild);
			//널이아닐때 지우란말과 같다 menuList.firstElementChild != null 
			//trucy falcy 찾아보기
			//while(menuList.firstElementChild )
			//	menuList.firstElementChild.remove();

			//다지우면 널이나오니까 널나오기전까지 계속 지우라고 하면됨
			console.log(menuList.firstElementChild);
*/
			
		function bind(menus){

			//목록지우는방법2 
			//menuList.textContent ="<span style = 'colcor:blue';>test hello</span>"
			//menuList.innerText = "<span style = 'blue';>test hello</span>"
			//menuList.innerHTML = "<span style = 'blue';>test hello</span>"
			menuList.innerHTML = "";

			//목록 만들어 채우기
			//방법1: DOM 객체 직접 생성해서 채우기

			//			let menuSection = document.createElement("section");
			//			menuSection.className="menu";
			//			
			//			let form = document.createElement("form");
			//			form.className="";
			//			
			//			//menuSection.appendChild(form); //node interface기능
			//			menuSection.append(form); //element inteface 기능
			//			
			//			menuList.append(menuSection);

			//방법2: 문자열 이용한 객체 생성
			for(let m of menus){
			let template = `<section class="menu">
					<form class="">
						<h1>
							<span>${m.name}</span>/<span
								style="font-size: 11px;">${m.categoryName}</span>
						</h1>
						<div class="menu-img-box">
							<a href="detail?id=${m.id}"><img class="menu-img" src="/image/menu/${m.img}"></a>
						</div>
						<div class="menu-price">${m.price} 원</div>
						<div class="menu-option-list">
							<span class="menu-option"> 
							<input class="menu-option-input" type="checkbox"> <label>ICED</label></span> 
							<span class="menu-option ml-2"> <input	class="menu-option-input" type="checkbox"> 
							<label>Large</label>
							</span>
						</div>
						<div class="menu-button-list">
							<input class="btn btn-fill btn-size-1 btn-size-1-lg" type="submit" value="담기"> 
							<input class="btn btn-line btn-size-1 btn-size-1-lg ml-1" type="submit" value="주문하기">
						</div>
					</form>
				</section>`;
			//menuList.innerHTML += template; 추가가아니고 모든걸 부수고 새로짓는방식이라 오버헤드가 발생
			menuList.insertAdjacentHTML("beforeend",template);//위치만 정해주면 새로만드는게 아니라 추가됨 윗줄과 비교하면 눈에띄게 속도향상.
			}
			
		};
		
	

});