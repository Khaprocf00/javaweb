<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="form-structor">
		<form action="">
			<div class="signup slide-up">
				<h2 class="form-title" id="signup">
					<span>or</span>Sign up
				</h2>
				<div class="form-holder">
					<input type="text" class="input" placeholder="Name" name="username"/> <input
						type="text" class="input" placeholder="Username" /> <input
						type="password" class="input" placeholder="Password"   name="password"/>
				</div>
				<button class="submit-btn">Sign up</button>
			</div>
		</form>
		<form action="" method="POST">
			<div class="login ">
				<div class="center">
					<h2 class="form-title" id="login">
						<span>or</span>Log in
					</h2>
					<div class="form-holder">
						<input type="text" class="input" placeholder="Username"  name="username"/> <input
							type="password" class="input" placeholder="Password" name = "password"/>
					</div>
					<button type="submit" class="submit-btn">Log in</button>
					<div class="alert alert-${alert}" role="alert">${message}</div>
				</div>
				
			</div>
		</form>
	</div>
</body>
</html>