

Vue
	.createApp(
		{

			data() {
				return {
					test: "hello",
					list: [

					],
					isShowRegForm: true,
					menu: { name: "", price: 0 }
				};

			},
			methods: {

				menuSaveHandler() {


					var myHeaders = new Headers();
					myHeaders.append("Content-Type", "application/json");

					var raw = JSON.stringify(this.menu);

					var requestOptions = {
						method: 'POST',
						headers: myHeaders,
						body: raw,
						redirect: 'follow'
					};

					fetch("http://localhost:8080/menus", requestOptions)
						.then(response => response.text())
						.then(result => {
							if(result==="ok");
							this.load();
						})
						.catch(error => console.log('error', error));
					
				},

				menuAddHandler() {
					this.isShowRegForm = !this.isShowRegForm
					console.log("menu add")
				},


				categoryClickHandler(e) {

					//뒤부터넣는거 push() 뒤부터꺼내는거pop()shift()앞에서꺼내기 unhsift()앞에서넣기
					//this.list.push({ id: 4, name: "디카페인 아메리카노", price: 5500 });
	
				},
				load() {
					//		let promise = 
					fetch("/menus")
						//		promise
						.then(response => {
							return response.json();
						})
						.then(list => {
							this.list = list;
						})
						//			.then(menu => {
						//				console.log(menu.name);
						//			})
						.catch(error => {
							console.log("aaaa");
						});

					//		----------------프로미스방식2---------------------
					//		load(cid){
					//			let promise = fetch("/menus");
					//			promise
					//			.then(response=>{
					//				let promise = response.json();
					//				promise.then(list=>{
					//					console.log(list);
					//				});
					//			});
					//		-----------------프로미스방식1----------------------------
					//		//비동기->동기형으로 바꾸는 방식
					//		async load(cid){
					//			
					//			let response = await fetch("/menus");
					//			let list = await response.json();
					//			console.log(list);
					//		-----------------콜백방식---------------------------
					//			return new Promise(resolve=>{
					//			//콜백함수를 사용하는 request 객체의 send();
					//			//일정한시간 뒤에 처리하게하는 함수. 그동안 비동기처리해줌
					//			setTimeout(()=>{
					//				console.log("load");
					//				callback();
					//			},100);
					//		});
					//		}
					//	}
				}
			},
			//	beforeCreate(){console.log("beforeCreate")},
			//	created(){console.log("created")},
			//	beforeMount(){console.log("beforeMount")},
			mounted() {

				console.log("mounted")
				this.load()

			},
			//	beforeUpdate(){console.log("beforeUpdate")},
			//	updated(){console.log("updated")},
			//	beforeUnmount(){console.log("beforeUnmount")},
			//	unmounted(){console.log("unmounted")}

		})
	.mount("#main-section");


