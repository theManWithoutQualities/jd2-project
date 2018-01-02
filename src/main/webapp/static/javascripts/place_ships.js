$(document).ready(function(){
    $('.field_my').each(function(){

            var matrix = new Array(10);
            for(var i=0; i<10; i++){
                matrix[i] = new Array(10);
            }
            for(var i=0; i<10; i++){
                    for(var j=0; j<10; j++){
                            matrix[i][j]=0;
                    }
            }
            
            for(var i=0; i<10; i++){
                matrix[$("#ship_y_"+$(this).attr('id')+"_"+i).val()][$("#ship_x_"+$(this).attr('id')+"_"+i).val()]=1;
                if($("#ship_orient_"+$(this).attr('id')+"_"+i).val()=="HORIZONTAL"){
                    for(var ind=1; ind<$("#ship_length_"+$(this).attr('id')+"_"+i).val(); ind++){
                        matrix[$("#ship_y_"+$(this).attr('id')+"_"+i).val()][$("#ship_x_"+$(this).attr('id')+"_"+i).val()*1+ind]=1;
                    }
                }else{
                    for(var ind=1; ind<$("#ship_length_"+$(this).attr('id')+"_"+i).val(); ind++)
                        matrix[$("#ship_y_"+$(this).attr('id')+"_"+i).val()*1+ind][$("#ship_x_"+$(this).attr('id')+"_"+i).val()]=1;
                }
            }
            
            

            for(var i=0; i<$("#count_shots_"+$(this).attr('id')).val(); i++){
                matrix[$("#shot_y_"+$(this).attr('id')+"_"+i).val()][$("#shot_x_"+$(this).attr('id')+"_"+i).val()]+=2;
            }                

            
            for(var i=0; i<10; i++){
                    for(var j=0; j<10; j++){
                            if(matrix[i][j]==0)
                               $("#"+$(this).attr('id')+"_"+j+"_"+i).css("background-color","green");
                            else if(matrix[i][j]==1)
                               $("#"+$(this).attr('id')+"_"+j+"_"+i).css("background-color","yellow");
                            else if(matrix[i][j]==2)
                               $("#"+$(this).attr('id')+"_"+j+"_"+i).css("background-color","brown");
                            else if(matrix[i][j]==3)
                               $("#"+$(this).attr('id')+"_"+j+"_"+i).css("background-color","red");
                    }
            }


    });

    $('.field_rival').each(function(){
        
            var matrix = new Array(10);
            for(var i=0; i<10; i++){
                matrix[i] = new Array(10);
            }
            for(var i=0; i<10; i++){
                    for(var j=0; j<10; j++){
                            matrix[i][j]=0;
                    }
            }
            
            for(var i=0; i<10; i++){
                
                matrix[$("#ship_y_"+$(this).attr('id')+"_"+i).val()][$("#ship_x_"+$(this).attr('id')+"_"+i).val()]=1;
                if($("#ship_orient_"+$(this).attr('id')+"_"+i).val()=="HORIZONTAL"){
                    for(var ind=1; ind<$("#ship_length_"+$(this).attr('id')+"_"+i).val(); ind++){
                        matrix[$("#ship_y_"+$(this).attr('id')+"_"+i).val()][$("#ship_x_"+$(this).attr('id')+"_"+i).val()*1+ind]=1;
                    }
                }else{
                    for(var ind=1; ind<$("#ship_length_"+$(this).attr('id')+"_"+i).val(); ind++)
                        matrix[$("#ship_y_"+$(this).attr('id')+"_"+i).val()*1+ind][$("#ship_x_"+$(this).attr('id')+"_"+i).val()]=1;
                }
            }

            for(var i=0; i<$("#count_shots_"+$(this).attr('id')).val(); i++){
                matrix[$("#shot_y_"+$(this).attr('id')+"_"+i).val()][$("#shot_x_"+$(this).attr('id')+"_"+i).val()]+=2;
            }                 


            for(var i=0; i<10; i++){
                    for(var j=0; j<10; j++){
                        if(matrix[i][j]==2)
                            $("#"+$(this).attr('id')+"_"+j+"_"+i).css("background-color","brown");
                        else if(matrix[i][j]==3)
                            $("#"+$(this).attr('id')+"_"+j+"_"+i).css("background-color","red");
                    }
            }
    });

    $('.field_rival'+' .cell').each(function(){
        var color = $(this).css('backgroundColor');
        $(this).hover(function(){
            $(this).css("background-color","black");
        },
        function(){
            $(this).css("background-color",color);
        }
        );

        $(this).click(function(){
            location='shot/'+$(this).attr('class').match(/\w+|"[^"]+"/g)[1]+"_"+$(this).attr('id').split("_")[2]+"_"+$(this).attr('id').split("_")[3];
        });

    });

    $('button.start_place').click(function(){

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

        
});