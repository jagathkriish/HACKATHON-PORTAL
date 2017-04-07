	alert("in dash board 3");
	var $pagination = $('#paginationId');
    var defaultOpts = {
        totalPages: 20
    };
    $pagination.twbsPagination(defaultOpts);
    $.ajax({url: baseurl+"/apvdIdeaPages?page=1&size=5",
        	success: function (data) {
        	//alert(JSON.stringify(data.totalElements));
            var totalPages = data.totalPages;
            var currentPage = $pagination.twbsPagination('getCurrentPage');
            $pagination.twbsPagination('destroy');
            $pagination.twbsPagination($.extend({}, defaultOpts, {
                startPage: currentPage,
                totalPages: totalPages,
                onPageClick: function (event, page) {
                	$("html, body").animate({ scrollTop: 0 }, "slow");
                	var pagenum = Number(page)-1;
                	$.ajax({url: baseurl+"/apvdIdeaPages?page="+pagenum+"&size=5",
                    	success: function (data) {
                    		$("#postdiv").html("");
                    		$.each(data.content, function (index, value) {
                    			var role = $("#roleId").text();
                        		$("#postdiv").append(' <div style="background-color: red;"><div style="background-color: skyblue;"><table><tr><td>Idea Id&nbsp;: &nbsp;</td><td>'+value.id+'</td></tr><tr><td>Solution Title&nbsp;: &nbsp;</td><td>'+value.solnTitle+'</td></tr><tr><td>Rating&nbsp;:&nbsp;</td><td>'+value.rating+'</td></tr></table></div><p class="bg-info"><a href="#" onclick="openDetails(\''+value.id+'\',\''+value.problem+'\',\''+value.industry+'\',\''+value.areaOfFunc+'\',\''+value.technology+'\',\''+value.solnTitle+'\',\''+value.solnDesc+'\',\''+value.buBenefit+'\',\''+value.status+'\',\''+value.rating+'\',\''+value.profile.capName+'\',\''+value.profile.capId+'\',\''+value.profile.capEmail+'\',\''+value.profile.phone+'\',\''+value.profile.buService+'\',\''+value.profile.project+'\',\''+value.profile.location+'\',\''+value.buInvest+'\',\''+value.buIncome+'\',\''+value.itype+'\')">&nbsp;More...</a> &nbsp;<a href="#" onclick="openContributeForm()">Contribute</a></p></div>');
                    		});
                    	}
                	});
                }
            }));
        }
    });
    
   
    $(document).ready(function(){
    	 var rowCount=1;
       $("#add_row").click(function(){
        if( rowCount <= 4){
    	   $('#addr'+rowCount).html("<td>"+ (rowCount+1) +"</td><td>&nbsp;</td><td><input name='name"+rowCount+"' type='text' required placeholder='Name' class='form-control input-md'  /> </td><td><input required name='mail"+rowCount+"' type='text' placeholder='Mail'  class='form-control input-md'></td><td><input required name='project"+rowCount+"' type='text' placeholder='Project/Account'  class='form-control input-md'></td><td><input required type='text' name='tech"+rowCount+"' placeholder='Technologies' class='form-control'/></td><td><input required type='text' name='role"+rowCount+"' placeholder='Role' class='form-control'/></td>");

        $('#tab_logic').append('<tr id="addr'+(rowCount+1)+'"></tr>');
        rowCount++; 
       }
    });
       
       
       $("#delete_row").click(function(){
      	 if(rowCount>1){
  		 $("#addr"+(rowCount-1)).html('');
  		rowCount--;
  		 }
  	 });
       
       
     
         
     

  });
    
    
  
    
    function openDetails(data,data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12,data13,data14,data15,data16,data17,data18,data19){
    	
    	document.getElementById("setideaid").innerHTML = data;
    	document.getElementById("hidideaid").value = data;
    	document.getElementById("setprob").innerHTML = data1;
    	document.getElementById("setindustry").innerHTML = data2;
    	document.getElementById("setareaoffunc").innerHTML = data3;
    	document.getElementById("settech").innerHTML = data4;
    	document.getElementById("setsoltitle").innerHTML = data5;
    	document.getElementById("setsoldesc").innerHTML = data6;
    	document.getElementById("setbubenift").innerHTML = data7;
    	document.getElementById("setbuinvest").innerHTML = data17;
    	document.getElementById("setbuincome").innerHTML = data18;
    	document.getElementById("setstatus").innerHTML = data8;
    	document.getElementById("setrating").innerHTML = data9;
    	document.getElementById("setcapname").innerHTML = data10;
    	document.getElementById("setcapid").innerHTML = data11;
    	document.getElementById("setcapmail").innerHTML = data12;
    	document.getElementById("setphone").innerHTML = data13;
    	document.getElementById("setbuservice").innerHTML = data14;
    	document.getElementById("setproject").innerHTML = data15;
    	document.getElementById("setlocation").innerHTML = data16;
    	document.getElementById("setItype").innerHTML = data19;

    	
    	document.getElementById("detailsNav").style.width = "100%";
    	document.getElementById("detailsNav").style.display = "block";
    	
    	document.getElementById("headerdiv").style.display = "none";
    	document.getElementById("postdiv").style.display = "none";
    	document.getElementById("paginationDivID").style.display = "none";
    	
    }
    
    function openContributeForm(data,data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11,data12,data13,data14,data15,data16,data17,data18,data19){
    	
    	document.getElementById("contributeNav").style.width = "100%";
    	document.getElementById("contributeNav").style.display = "block";
    	
    	document.getElementById("headerdiv").style.display = "none";
    	document.getElementById("postdiv").style.display = "none";
    	document.getElementById("paginationDivID").style.display = "none";
    	
    }
    
    function closeDetails(){
    	document.getElementById("detailsNav").style.width = "0%";
    	document.getElementById("detailsNav").style.display = "none";
    	
    	document.getElementById("headerdiv").style.display = "block";
    	document.getElementById("postdiv").style.display = "block";
    	document.getElementById("paginationDivID").style.display = "block";
    	
    	document.getElementById("viewCmtHist").innerHTML = "";
    }
    
    function closeContributeForm(){
    	document.getElementById("contributeNav").style.width = "0%";
    	document.getElementById("contributeNav").style.display = "none";
    	
    	document.getElementById("headerdiv").style.display = "block";
    	document.getElementById("postdiv").style.display = "block";
    	document.getElementById("paginationDivID").style.display = "block";
    	
    }
    
    function getComentHistory(){
 		var id = document.getElementById("hidideaid").value;
     	var appstr = "<table><tr><td>";
     	$.ajax({url: baseurl+"/iComments/"+id,
         	success: function (data) {
         		for(var i=0;i<data.length;i++){
         			appstr += '<table class="cmtClass"><tr><td>'+data[i].comment +'</td></tr><tr><td>(&nbsp;by : &nbsp;'+data[i].commentedBy+'&nbsp;)</td></tr></table>';
         		}
         		appstr+="</tr></td></table>";
         		document.getElementById("viewCmtHist").innerHTML = appstr;
         		
         	},error: function (e) {
             	alert("Error in Comment History   "+e.error);
             }
     	});
     	
     }
     
     
     function enableContribute(val){
     	if(val == "1"){
     	document.getElementById("add_row").style.display = "none";
     	document.getElementById("delete_row").style.display = "none";
     	
     	document.getElementById("contributeTeam").style.display = "none";
     	document.getElementById("contributeIndi").style.display = "block";
     	
     	}else if(val == "2"){
     	document.getElementById("add_row").style.display = "block";
     	document.getElementById("delete_row").style.display = "block";
     	
     	document.getElementById("contributeTeam").style.display = "block";
     	document.getElementById("contributeIndi").style.display = "none";
     	
     	}
     }
     
