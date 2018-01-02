$(document).ready(function(){

    var input_id=0;

    $('.field .cell').mousedown(function(event){
        if(input_id<10){
            var length=0;
            if(input_id==0)
                length=4;
            else if((input_id>0)&&(input_id<3))
                length=3;
            else if((input_id>2)&&(input_id<6))
                length=2;
            else if((input_id>5))
                length=1;
            switch(event.which){
                case 1:
                    $(this).css("background-color", "yellow");
                    for(var ind=1; ind<length; ind++){
                        var x=$(this).attr('id').split("_")[0]*1+ind;
                        var y=$(this).attr('id').split("_")[1]*1;
                        $('.field .cell#'+x+"_"+y).css("background-color", "yellow");
                    }
                    $('input[name='+input_id+']').val($(this).attr('id')+'_h');
                    break;
                case 3:
                    $(this).css("background-color", "yellow");
                    for(var ind=1; ind<length; ind++){
                        var x=$(this).attr('id').split("_")[0]*1;
                        var y=$(this).attr('id').split("_")[1]*1+ind;
                        $('.field .cell#'+x+"_"+y).css("background-color", "yellow");
                    }
                    $('input[name='+input_id+']').val($(this).attr('id')+'_v');
                    break;
                default:
                    break;
            }
            input_id++;
        }
    });        
});