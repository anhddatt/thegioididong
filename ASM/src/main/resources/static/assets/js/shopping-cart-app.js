var indexCart = 0;

var app = angular.module("myapp", []);
app.controller("myCtrl1", function($scope, $http) {

	$http.get('/rest/products/list').then(function(response) {
		// Gán danh sách sản phẩm từ phản hồi API vào $scope.products
		$scope.products = response.data;
	});
	$http.get('/rest/category/list').then(function(response) {
		$scope.categorys = response.data;
	});
	$http.get('/rest/products/prodwithcate').then(function(response) {
		$scope.prodwcate = response.data;
	});

	$scope.create = function() {
		var item = angular.copy($scope.form);
		var url = `/rest/products/create`;
		$http.post(url, item).then(function(response) {
			$scope.key = resp.data.id;
			$scope.items[$scope.key] = item;
			productService.save(item).then(function(savedProduct) {
				alert('Sản phẩm đã được lưu vào cơ sở dữ liệu:', savedProduct);
			}, function(error) {
				// Xử lý lỗi nếu có
				alert('Lỗi khi lưu sản phẩm vào cơ sở dữ liệu:', error);
			});

		})
	}

	$scope.createAcc = function() {
		var item = angular.copy($scope.formAcc);
		var url = `/rest/accounts/create`;
		$http.post(url, item).then(function(response) {
			$scope.key = resp.data.id;
			$scope.items[$scope.key] = item;
			accountService.save(item).then(function(savedAccount) {
				alert('tài khoản đã được lưu vào cơ sở dữ liệu:', savedAccount);
			}, function(error) {
				// Xử lý lỗi nếu có
				alert('Lỗi khi lưu tài khoản vào cơ sở dữ liệu:', error);
			});

		})
	}

	$scope.editAcc = function(key) {
		var url = `/rest/accounts/${key}`;
		$http.get(url).then(function(response) {
			$scope.formAcc = response.data;
			$scope.key = key;
		})
	}

	$scope.edit = function(key) {
		var url = `/rest/products/${key}`;
		$http.get(url).then(function(response) {
			$scope.form = response.data;
			$scope.key = key;
		})
	}


	$scope.addCart = function(id) {
		var item = this.items.find(item => item.id == id);

		if (item) {
			item.quantity += 1;
			this.saveToLocalStorage();
		} else {
			$http.get(`/rest/products/${id}`).then(resp => {
				resp.data.quantity = 1;
				this.items.push(resp.data);
				this.saveToLocalStorage();
			});
		}
	};

	$scope.saveToLocalStorage = function() {
		var json = JSON.stringify(angular.copy($scope.items));
		localStorage.setItem("cart", json);
	};

	$scope.loadFormLocalStorage = function() {
		var json = localStorage.getItem("cart");
		this.items = json ? JSON.parse(json) : [];
	};


	$scope.removeCart = function(id) {
		var index = $scope.items.findIndex(item => item.id === id);
		if (index !== -1) {
			$scope.items.splice(index, 1);
			$scope.saveToLocalStorage();
		}
	};

	$scope.addClick = function(id) {
		var item = this.items.find(item => item.id == id);

		if (item) {
			item.quantity += 1;
			this.saveToLocalStorage();
		}
		/*if (typeof $rootScope.cart != 'undefined') {
			$rootScope.sumMoney = 0;
			for (var i = 0; i < $rootScope.cart.length; i++) {
				$rootScope.sumMoney = $rootScope.sumMoney + $rootScope.cart[i].quantity * $rootScope.cart[i].price;
			}
		}*/
	}



	$scope.subClick = function(id) {
		var item = this.items.find(item => item.id == id);

		if (item.quantity > 1) {
			item.quantity -= 1;
			this.saveToLocalStorage();
		}
		/*if (typeof $rootScope.cart != 'undefined') {
			$rootScope.sumMoney = 0;
			for (var i = 0; i < $rootScope.cart.length; i++) {
				$rootScope.sumMoney = $rootScope.sumMoney + $rootScope.cart[i].quantity * $rootScope.cart[i].price;
			}
		}*/
	}

	$scope.amount = function() {
		return this.items
			.map(item => item.quantity * item.price)
			.reduce((total, quantity) => total += quantity, 0);
	}
	$scope.count = function() {
		return this.items.length;
	}



	// Khởi tạo giỏ hàng từ Local Storage khi trang tải
	$scope.items = JSON.parse(localStorage.getItem("cart")) || [];

	/*$scope.cart = {
		items: [],
		
		//Thêm sản phẩm vào giỏ hàng
		addCart(id) {
			var item = this.items.find(item => item.id == id);

			if (item) {
				item.quantity += 1;
				this.saveToLocalStorage();
			} else {
				$http.get(`/rest/products/${id}`).then(resp => {
					resp.data.quantity = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();

				})
			}

		},
		
	
	
	
	saveToLocalStorage(){
		var json = JSON.stringify(angular.copy(this.items));
		localStorage.setItem("cart",json);	
	},
	
	
	}*/
});


/*//Nhấn nút Cộng để thêm sản phẩm
$scope.addClick = function(index) {
	$rootScope.cart[index].quantity = $rootScope.cart[index].quantity + 1;
	if (typeof $rootScope.cart != 'undefined') {
		$rootScope.sumMoney = 0;
		for (var i = 0; i < $rootScope.cart.length; i++) {
			$rootScope.sumMoney = $rootScope.sumMoney + $rootScope.cart[i].quantity * $rootScope.cart[i].price;
		}
	}
}
//trừ
$scope.subClick = function(index) {
	if ($rootScope.cart[index].quantity > 1) {
		$rootScope.cart[index].quantity = $rootScope.cart[index].quantity - 1;
	}
	if (typeof $rootScope.cart != 'undefined') {
		$rootScope.sumMoney = 0;
		for (var i = 0; i < $rootScope.cart.length; i++) {
			$rootScope.sumMoney = $rootScope.sumMoney + $rootScope.cart[i].quantity * $rootScope.cart[i].price;
		}
	}
}
//Xóa sản phẩm trong giỏ hàng
$scope.delProduct = function(index) {
	$rootScope.cart.splice(index, 1);
	if (typeof $rootScope.cart != 'undefined') {
		$rootScope.sumMoney = 0;
		for (var i = 0; i < $rootScope.cart.length; i++) {
			$rootScope.sumMoney = $rootScope.sumMoney + $rootScope.cart[i].quantity * $rootScope.cart[i].price;
		}
	}
}
$scope.products = [];
$http.get("sanpham.json").then(function(response) {
	$scope.products = response.data;
});


$scope.index = $routeParams.url;
$scope.limit = 10;
$scope.loadMore = function() {
	$scope.limit += 20;

}
$scope.showless = function() {
	$scope.limit = 10;
}
$scope.scrollToTop = function() {
	window.scrollTo(0, 0);
}


});*/