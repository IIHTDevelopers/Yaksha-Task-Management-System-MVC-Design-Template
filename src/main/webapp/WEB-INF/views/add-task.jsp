<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Task</title>
</head>
<body>
    <h1>Add New Task</h1>
    <form action="/task/add" method="POST">
        <label for="name">Task Name:</label>
        <input type="text" id="name" name="name" required/><br><br>

        <label for="description">Task Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <button type="submit">Add Task</button>
    </form>

    <br><a href="/">Back to Task List</a>
</body>
</html>
