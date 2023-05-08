<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Button Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        fetch('MyServlet')
            .then(response => response.json())
            .then(data => {
                document.getElementById('header').textContent = data.header;
                document.getElementById('button1').textContent = data.button1;
                document.getElementById('button2').textContent = data.button2;
                $("#button1").show();
                $("#button2").hide();


            })
            .catch(error => console.error(error));

        $(document).ready(function () {
            $("#button1").click(function () {
                var textInputValue = $("#textInput").val();
                $.post("MyServlet", {
                    buttonOneState: "1",
                    buttonTwoState: "0",
                    textInputValue: textInputValue
                }, function (data) {
                    if (data) {
                        $("#button1").text(data.button1);
                        $("#button2").text(data.button2);
                        $("#header").text(data.header);
                        $("#label3").text(data.userName);
                        $("#label5").text(data.gameNumber);

                        if (data.button2Visibility === "0") {
                            $("#button2").hide();
                        } else {
                            $("#button2").show();
                        }
                        if (data.textInputVisibility === "1") {
                            $("#textInput").show();
                        } else {
                            $("#textInput").hide();
                        }

                        if (data.labelTextVisibility === "1") {
                            $("#label1").show();
                        } else {
                            $("#label1").hide();
                        }
                    }
                });
            });

            $("#button2").click(function () {
                $.post("MyServlet", {buttonOneState: "0", buttonTwoState: "1"}, function (data) {
                    if (data) {
                        $("#button1").text(data.button1);
                        $("#button2").text(data.button2);
                        $("#header").text(data.header);

                        if (data.button2Visibility === "0") {
                            $("#button2").hide();
                        } else {
                            $("#button2").show();
                        }
                        if (data.textInputVisibility === "1") {
                            $("#textInput").show();
                        } else {
                            $("#textInput").hide();
                        }

                        if (data.labelTextVisibility === "1") {
                            $("#label1").show();
                        } else {
                            $("#label1").hide();
                        }

                    }
                });
            });


        });
    </script>
</head>
<body>
<h1 id="header">Welcome to the quest!</h1>
<label id="label1" for="textInput">Your name:</label>
<input type="text" id="textInput" name="textInput">
<button id="button1">Button 1</button>
<button id="button2">Button 2</button>
<br>
<br>
<br>
<label id="label2">User name:</label>
<label id="label3"></label>
<br>
<label id="label4">Game number:</label>
<label id="label5"></label>
</body>
</html>
