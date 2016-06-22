var countElements = 0;
var state = 0;

$(document).ready(function(){
   // jQuery method to chose column for sorting

	var a = ['tdFile', 'tdSize', 'tdDate'];
    $("th").click(function(){
		if (state % 2 != 0) {
			$("th").css("background-color", "yellow").removeClass().not(this);
            $(this).css("background-color", "#cccccc").addClass("flagUp");
		} else {
			$("th").css("background-color", "yellow").removeClass().not(this);
			$(this).css("background-color", "#cccccc").addClass("flagDown");
		}
		clickToSort(a.indexOf($(this).attr('id')));
        });
});

$(function output(k) {
	// read json to table

	$.getJSON('data.json', function (data) {
		$.each(data.data, function (index, file) {
			var rowArr = "<tr>" + "<td id='tdFile'>" + "<a href=''>" + file.fileName + "</a>" + "</td>" +
				"<td id='tdSize'>" + file.fileSize + "</td>" + "<td id='tdDate'>" + file.date + "</td>" + "<td id='tdDel'>" + "<a href=''>" +
				"Удалить" + "</a>" + "</td>" + "</tr>";
			$(rowArr).appendTo("#tableData #tableBody");
			countElements++;
		});
	});
});


function clickToSort(k){
	var order = [];
	for(var index=0; index < countElements+1; index++){
		order[index] = [];
	}

	$.getJSON('data.json', function clickToSort(data) {
		$.each(data.data, function clickToSort(index, file) {
		    order[index].push(file.fileName);
		    order[index].push(file.fileSize);
		    order[index].push(file.date);
		});

		// bubble sort algorithm
		var x = 0;
		if (state%2 === 0){
			do{
			for (var j=0; j < countElements - 1; ++j) {
                        var check = order[j][k] > order[j+1][k];
   				if(check===true){
   					var a=order[j];
  					order[j]=order[j+1];
      				order[j+1]=a; 
   				}
    		}
    		x++;
			} while (x < countElements);
		}
		else {
			do{
			for (j=0; j < countElements - 1; ++j) {
			    check = order[j][k] < order[j+1][k];
   				if(check==true){
   					a=order[j];
  					order[j]=order[j+1];
      				order[j+1]=a; 
   				}
    		}
    		x++;
			} while (x < countElements);
		}
		
		// table with result of sorting
		var output = [];
		var finalOutput = "";
		for ( var index=0; index < countElements; index++ ){
			output[index] = "<tr>" + "<td id='tdFile'>" + "<a href=''>" + order[index][0] + "</a>" + "</td>" +
			"<td id='tdSize'>" + order[index][1] + "</td>" + "<td id='tdDate'>" + order[index][2] +
			"</td>" + "<td id='tdDel'>" + "<a href=''>" + "Удалить" + "</a>" + "</td>" + "</tr>";
		    finalOutput += output[index];
			}

		$('#tableBody').html(finalOutput);
		state++;
    });
}



