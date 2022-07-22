let index = {
    init: function(){
        $("#btn-save").on("click",()=>{
            this.save();
        });
    },

    save: function(){
        alert("user save function call");
    }

}

index.init();