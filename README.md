# CRUDExercise
CRUD Exercise
Cài đặt:

Import project => Run project 
=> Open web browser: http://localhost:8080/swagger-ui.htm  - sẽ hiện các http methods để test
Mô tả:
Project mô phỏng các chức năng Create, Read, Update, và Delete.
Project gồm có file 	Swagger2Config: config swagger
			User Controller: Điều hướng
			User : Entity tương ứng với bảng user trong database
			UserDTO: Dùng để trả về các trường được phép hiển thị cho người dùng
			CreateUserRequest: Validate cơ bản các trường được nhập vào từ người dùng
			UserRepository: Repository
			UserService: Các hàm xử lí logic (Create, update, delete, getUser)