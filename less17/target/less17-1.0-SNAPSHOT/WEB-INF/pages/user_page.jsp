<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Hello World in Backbone.js</title>
</head>
<body>

<div id="container">
</div>


<!-- ========= -->
<!-- Libraries -->
<!-- ========= -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js"
        type="text/javascript"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js" type="text/javascript"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/backbone-localstorage.js/1.1.16/backbone.localStorage-min.js"
        type="text/javascript"></script>

<script>
    var User = Backbone.Model.extend({
        urlRoot: "/web/users",
        defaults: {
            id: 1,
            name: "test_name",
            age: 12
        },
        initialize: function () {
            console.log("user model was created");
            this.on("change:name", function (model) {
                console.log("model->" + model.get("name"));
            })
        }
    });

    var user1 = new User();
    var user2 = new User({id:2, name: "JS_User", age: 12});

//    user1.fetch({
//        success: function (model) {
//            console.log(JSON.stringify(model))
//        },
//        error: function (model) {
//            console.log("error");
//        }
//    });

    user2.save({
        success: function (model) {
            console.log(JSON.stringify(model))
        },
        error: function (model) {
            console.log("error");
        }
    });

    //    console.log(JSON.stringify(user));
    //    console.log(JSON.stringify(user2));

    var UserCollection = Backbone.Collection.extend({
        model : User
    });

    var usersCollection = new UserCollection([user1, user2, new User({name:"Ivan", age:12})]);
    console.log(JSON.stringify(usersCollection));

</script>

</body>