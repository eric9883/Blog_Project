let index = {
    init: function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });
    },

    save: function(){
        let data = {
            username: $("#username").val(),
            password: $("#password").val(),
            email: $("#email").val(),
            contentType: "application/json; charset=utf-8", // notify what BODY data type is (MIME)
            dataType: "json"    // response from server

        }

        $.ajax({
            type: "POST",
            url: "/blog/api/user",
            data: JSON.stringify(data), //Javascript Language to JAVA => JSON string
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            alert("Join Completed!!");
            location.href ="/blog";

        }).fail(function(error){
            alert(JSON.stringify(error));

        });
    }

}

index.init();