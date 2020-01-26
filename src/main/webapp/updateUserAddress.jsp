<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update User Address!</h1>
        <form method="POST" action="updateUserAddress">

            <!-- Id input-->
            <div>
                <label for="id">Id</label>  
                <div>
                    <input id="id" name="id" type="number" placeholder="id">
                </div>
            </div>

            <!-- Address input-->
            <div>
                <label for="address">Address</label>  
                <div>
                    <input id="address" name="address" type="text" placeholder="address" required="">
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
