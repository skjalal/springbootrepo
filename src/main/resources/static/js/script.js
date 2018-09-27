$(function() {
	
});

function getListOfCompanies(companyId) {
	$('#'+companyId).DataTable({
		"processing": true,
        "serverSide": true,
		"ordering": false,
        "info":  true,
        "searching": false,
        "scrollX": true,
        "scrollY": true,
        "scrollCollapse": true,
        "autoWidth": true,
        "pagingType": "full_numbers",
        "ajax": {
        	"url" : "../superadminrest/companies",
        	"type": 'GET',
            "datatype": 'json',
            "data" : function(d) {
            	if(companyId == 'activeCompanyTable') {
            		d.searchFilter = 'active';
            	} else if(companyId == 'inActiveCompanyTable') {        		
            		d.searchFilter = 'inactive';
            	}
            }
        },
        "language" : {
        	"processing" : "<img src='../images/loading_confrm.gif'>",
        	"infoFiltered": "",
        	"emptyTable" : "No records found with given search criteria"
        },
        "columns" : [{ "data": "companyCode" },
					 { "data": "companyName" },
					 { "data": "createdDate" }],
        "initComplete": function(settings, json) {
        	if(companyId == 'activeCompanyTable') {
        		$('#activeCount').text(json.recordsTotal);
        	} else if(companyId == 'inActiveCompanyTable') {        		
        		$('#inactiveCount').text(json.recordsTotal);
        	}
        },
		"drawCallback" : function(settings) {
			
        }
	});
}