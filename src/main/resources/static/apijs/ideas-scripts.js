	var $pagination = $('#paginationId');
    var defaultOpts = {
        totalPages: 20
    };
    $pagination.twbsPagination(defaultOpts);
    $.ajax({url: baseurl+"/ideaPages?page=1&size=5",
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
                	$.ajax({url: baseurl+"/ideaPages?page="+pagenum+"&size=5",
                    	success: function (data) {
                    		$("#postdiv").html("");
                    		$.each(data.content, function (index, value) {
                    			var role = $("#roleId").text();
                        		$("#postdiv").append('<div class="blog-post"><div class="post-content"><h3 class="post-title"><a href="#">'+value.profile.capId+'<br>'+value.profile.capName+'</a></h3><div class="meta"><span class="meta-part"><a href="#" onclick="openDetails(\''+value.id+'\',\''+value.problem+'\',\''+value.industry+'\',\''+value.areaOfFunc+'\',\''+value.technology+'\',\''+value.solnTitle+'\',\''+value.solnDesc+'\',\''+value.buBenefit+'\',\''+value.status+'\',\''+value.rating+'\',\''+value.profile.capName+'\',\''+value.profile.capId+'\',\''+value.profile.capEmail+'\',\''+value.profile.phone+'\',\''+value.profile.buService+'\',\''+value.profile.project+'\',\''+value.profile.location+'\',\''+value.buInvest+'\',\''+value.buIncome+'\',\''+value.itype+'\')"><i class="icon-user"></i>Click for More...</a></span><span class="meta-part"><a href="#"><i class="icon-calendar"></i>'+moment(value.createdAt,"x").format("MMMM Do YYYY, h:mm:ss a")+'</a></span><span class="meta-part"><a href="#"><i class="icon-event"></i> Hackathon</a></span><span class="meta-part"><a href="#"><i class="icon-bubbles"></i> '+value.profile.capName+'</a></span></div><p>'+value.solnDesc+'.</p><div class="row"><div class="rateyo col-md-3 form-control" id="'+value.profile.capId+'S"></div><div class="col-md-2"><input class="form-control" id="'+value.profile.capId+'R" type="text" readonly="true"></div><div class="col-md-7"><div class="col-md-6"><select class="form-control" id="'+value.profile.capId+'B" value="'+value.status+'"><option value="initial">Initial</option><option value="approve">Approve</option><option value="assign">Assign</option><option value="review">review</option><option value="publish">Publish</option><option value="reject">Reject</option><option value="onhold">On-Hold</option></select></div><div class="col-md-4"><input type="button" class="btn btn-success form-control" value="Update" onclick="rateIdea(\''+value.profile.capId+'\',\''+value.rating+'\',\''+value.status+'\')"></div><div class="col-md-2" style="padding-top:20px"><a href="'+baseurl+'/files/'+value.documentName+'"><i class="fa fa-download fa-2x" aria-hidden="true"></i></a></div></div></div></div></div>');
                        		if(role.indexOf("ROLE_ADMIN") === -1){
                        			$("#"+value.profile.capId+"B").attr('disabled',true);
                        		}
                        		$("#"+value.profile.capId+"S").rateYo({
                      	          rating: value.rating,
                      	          numStars: 5,
                      	          precision: 2,
                      	          minValue: 1,
                      	          maxValue: 5,
                                  onInit: function () {
                                	  $("#"+value.profile.capId+"R").val(value.rating);
                                	  if(value.status != "NA" || value.status != ""){
                                		  $("#"+value.profile.capId+"B").val(value.status);
                                	  }
                                }
                      	        }).on("rateyo.change", function (e, data) {
                      	        	$("#"+value.profile.capId+"R").val(data.rating);
                      	     });
                    		});
                    	}
                	});
                }
            }));
        }
    });
    function rateIdea(id, extRtng, extSts){
    	var token = $('#_csrf').attr('content');
    	var header = $('#_csrf_header').attr('content');
    	
    	$.ajax({
            type: "POST",
            url: baseurl+"/rateIdea",
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            data: {
            	capId : id,
            	exRtng : extRtng,
            	extSts : extSts,
            	rating : $("#"+id+"R").val(),
            	status : $("#"+id+"B").val()
            },
            timeout: 600000,
            success: function (data, textStatus, xhr) {
            	if(xhr.status == 200){
            		alert("Review Successful");	
            	}
            },
            error: function (e, textStatus, xhr) {
            	alert(xhr.status);
            }
		});
    }
    
    
    
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
    
    function getComentHistory(){
 		var id = document.getElementById("hidideaid").value;
     	var appstr = "<table>";
     	$.ajax({url: baseurl+"/iComments/"+id,
         	success: function (data) {
         		for(var i=0;i<data.length;i++){
         			appstr += '<tr><td class="cmtClass">'+data[i].comment +'</td></tr><tr><td>(&nbsp;by : &nbsp;'+data[i].commentedBy+'&nbsp;)</td></tr>';
         		}
         		appstr+="</table>";
         		document.getElementById("viewCmtHist").innerHTML = appstr;
         		
         	},error: function (e) {
             	alert("Error in Comment History   "+e.error);
             }
     	});
     	
     }
     
     
     function enableSearch(val){
     	if(val == "1"){
     	document.getElementById("verprcssearch").style.display = "block";
     	document.getElementById("namesearch").style.display = "none";
     	}else if(val == "2"){
     	document.getElementById("namesearch").style.display = "block";
     	document.getElementById("verprcssearch").style.display = "none";
     	}
     }
     
     function searchIdeas(){
     	
     	var resturl = getSearchUrl();
     	if(resturl != "NA"){
     	var srchUrl = baseurl+"/idea/search/"+resturl;
     	$.ajax({url: srchUrl,
         	success: function (valueAr) {
         		if(valueAr.length != 0){
         		var totalSearchArea = '<ul class="posts-list">';
         		 for(var i=0;i<valueAr.length;i++){
         			var value = valueAr[i];
         			var formSearchArea = '<li><div class="widget-thumb"><div class="widget-thumb"><a href="#"><img src="./assets/img/blog/p1.jpg" alt="" /></a></div> <div class="widget-content">';
         			formSearchArea += '<a href="#" onclick="openDetails(\''+value.id+'\',\''+value.problem+'\',\''+value.industry+'\',\''+value.areaOfFunc+'\',\''+value.technology+'\',\''+value.solnTitle+'\',\''+value.solnDesc+'\',\''+value.buBenefit+'\',\''+value.status+'\',\''+value.rating+'\',\''+value.profile.capName+'\',\''+value.profile.capId+'\',\''+value.profile.capEmail+'\',\''+value.profile.phone+'\',\''+value.profile.buService+'\',\''+value.profile.project+'\',\''+value.profile.location+'\',\''+value.buInvest+'\',\''+value.buIncome+'\',\''+value.itype+'\')">'+value.solnTitle+'</a>';
         			formSearchArea += '</div><div class="clearfix"></div></li>';   
         			
         			totalSearchArea += formSearchArea;
         		}
         		 
         		 totalSearchArea += '</ul>';
         		 
         		 $("#postSearchDiv").html("");
         		 $("#postSearchDiv").append(totalSearchArea);
         		 
         		}else{
         			$("#postSearchDiv").html("No results found for your Query.Try a different query ?");
         		}
         		 
         		totalSearchArea = "";formSearchArea = "";
         	},error: function (e) {
             	alert("Error in Searching   "+e.error);
             }
     	});
     	}
     }
     
     function getSearchUrl(){
     	
     	var radios = document.getElementsByName("srccrta");
     	var selOpt = "NA";
     	
     	for (var i = 0; i < radios.length; i++) {
     	    if (radios[i].checked) {
     	        selOpt = radios[i].value;
     	        break;
     	    }
     	}
     	
     	var url = "NA";
     	if(selOpt == "1"){
     		
    		var verid = document.getElementById("industry").value;
        	var funid = document.getElementById("funcarea").value;
     		
     	if(verid != "NA" && funid == "NA"){
     		url = "vertical/"+verid;
     	}else if(funid != "NA" && verid == "NA"){
     		url = "process/"+funid;
     	}else if(verid != "NA" && funid != "NA"){
     		url = "verprocs/"+verid+"/"+funid;
     	}
     	}else if(selOpt == "2" && soltitl != ""){
     		var soltitl = document.getElementById("namearea").value;
     		url = "soltitle/"+soltitl;
     	}
     	
     	return url;
     }
    
    function closeDetails(){
    	document.getElementById("detailsNav").style.width = "0%";
    	document.getElementById("detailsNav").style.display = "none";
    	
    	document.getElementById("headerdiv").style.display = "block";
    	document.getElementById("postdiv").style.display = "block";
    	document.getElementById("paginationDivID").style.display = "block";
    	
    	document.getElementById("viewCmtHist").innerHTML = "";
    }
    
    function commentIdea(){
    	var token = $('#_csrf').attr('content');
    	var header = $('#_csrf_header').attr('content');
    	var comment = $.trim($("#icomment").val());
    	var ideaId = $("#setideaid").text();
    	var cmtBy = $.trim($("#cmtrMail").val());
    	if((comment != '' && comment != null) || (cmtBy != '' && cmtBy != null)){
    		$.ajax({
                type: "POST",
                url: baseurl+"/commentIdea",
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                },
                data: {
                	ideaId:ideaId,
                	comment:comment,
                	commentedBy:cmtBy
                },
                timeout: 600000,
                success: function (data, textStatus, xhr) {
                	if(xhr.status == 200){
                		alert("Comment Successful");
                		$("#icomment").val('');
                	}
                },
                error: function (e, textStatus, xhr) {
                	alert(xhr.status);
                }
    		});
    	}else{
    		alert("Please fill out the mandatory fields indicated with * ");
    	}
    }