<html>
<head>
    <title>first web page</title>
</head>
<body>

n1:	<input type="text" id="n1" value="2"/>
<br/>

n2: <input type="text" id="n2" value="3"/>
<br/>

<input type="button" id="sum" onclick="sum();" value="Sum"/>
<br/>

<br/>

<input type="button" id="dynamic" onclick="dynamic();" value="Dynamic"/>

<form id="containerId">

</form>

<script type="text/javascript">
    function sum() {
        var n1 = document.getElementById("n1").value;
        var n2 = document.getElementById("n2").value;
        alert(parseInt(n1) + parseInt(n2));
    }

    function dynamic() {
        var container = document.getElementById("containerId");

        var input1 = document.createElement("input");
        input1.id = "in1";
        input1.type = "text";
        input1.value = "1";

        var input2 = document.createElement("input");
        input2.id = "in2";
        input2.type = "text";
        input2.value = "2";

        var button = document.createElement("input");
        button.id = "btn";
        button.type = "button";
        button.value = "Sum";

        button.onclick = function() {
            var nn1 = document.getElementById("in1").value;
            var nn2 = document.getElementById("in2").value;
            alert(parseInt(nn1) + parseInt(nn2));
        }

        document.getElementById("dynamic").visible = false;

        container.append(input1);
        container.append(input2);
        container.append(button);
    }
</script>

</body>
</html>
