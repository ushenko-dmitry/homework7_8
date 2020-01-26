<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create New User!</h1>
        <form method="POST" action="createUser">

            <!-- Username input-->
            <div>
                <label for="username">Username</label>  
                <div>
                    <input id="username" name="username" type="text" placeholder="username" required="">
                </div>
            </div>

            <!-- Password input-->
            <div>
                <label for="password">Password</label>
                <div>
                    <input id="password" name="password" type="password" placeholder="password" required="">
                </div>
            </div>

            <!-- isActive Checkboxes -->
            <div>
                <label for="isActive">isActive</label>
                <div>
                    <label for="isActive-0">
                        <input type="checkbox" name="isActive" id="isActive" value="isActive">
                    </label>
                </div>
            </div>

            <!-- Age input-->
            <div>
                <label for="age">Age</label>  
                <div>
                    <input id="age" name="age" type="number" placeholder="Age">
                </div>
            </div>

            <!-- Submit input-->
            <div>
                <label for="submit">Submit</label>  
                <div>
                    <input id="submit" name="submit" type="submit">
                </div>
            </div>
        </form>
    </body>
</html>
