$(document).ready(function() {
	$('#errorMessageTable').dataTable({
		"fnDrawCallback": function ( oSettings ) {
			/* Need to redo the counters if filtered or sorted */
			if ( oSettings.bSorted || oSettings.bFiltered )
			{
				for ( var i=0, iLen=oSettings.aiDisplay.length ; i<iLen ; i++ )
				{
					$('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr ).html( i+1 );
				}
			}
		},
		"iDisplayLength" : 100,
		"ajax" : {
			"url" : "/monitoring/error/list",
			"dataSrc" : ""
		},
		"columns" : [ {
			"data" : null
		}, {
			"data" : "timestamp",
			"render" : function(data, type, full, meta) {
				var javascriptDate = new Date(data);
				return javascriptDate.toLocaleString();
			}
		}, {
			"data" : "errorMessage",
			"render" : function(data, type, full, meta) {
				return data = data.replace(/(?:\r\n|\r|\n)/g, '<br />');
			}
		} ]
	});
});