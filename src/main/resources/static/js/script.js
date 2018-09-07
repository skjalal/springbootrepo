$(function() {
	$('#example').DataTable({
		"processing": true,
        "serverSide": true,
		"ordering": false,
        "info":  true,
        "searching": true,
        "scrollX": true,
        "scrollY": true,
        "scrollCollapse": true,
        "autoWidth": true,
        "pagingType": "full_numbers",
        "ajax": {
        	"url" : "companyDetails",
        	"type": 'GET',
            "datatype": 'json',
            "data" : function(d) {
            	d.searchFilter = d.search.value;
            }
        },
        "language" : {
        	"processing" : "<img src='images/loading_confrm.gif'>",
        	"infoFiltered": "",
        	"emptyTable" : "No records found with given search criteria"
        },
        "dom":"<'row'<'col-xs-12  col-sm-4 col-md-4'l><'col-xs-12  col-sm-4 col-md-4'f><'col-xs-12  col-sm-4 col-md-4'<'pull-right blackImgCls'B>>r>t<'col-xs-12  col-sm-6 col-md-6'i><'col-xs-12  col-sm-4 col-md-6'p>",
        "columns" : [{ "data": "companyId", "title" : "Company ID" },
					 { "data": "companyName", "title" : "Company Name" },
					 { "data": "address", "title" : "Address" },
					 { "data": "city", "title" : "City" },
					 { "data": "state", "title" : "State" },
					 { "data": "country" , "title" : "Country"},
					 { "data": "pin", "title" : "Pin" },
					 { "data": "phone", "title" : "Phone" },
					 { "data": "fax", "title" : "Fax" },
					 { "data": "statusFlag", "title" : "Status Flag" },
					 { "data": "licenseCount", "title" : "License Count" },
					 { "data": "fromdate", "title" : "From Date" },
					 { "data": "todate", "title" : "To Date" },
					 { "data": "totalLicense", "title" : "Total License" },
					 { "data": "compUrl", "title" : "Company URL" },
					 { "data": "company", "title" : "Company" }],
        "initComplete": function(settings, json) {
        	
        },
		"drawCallback" : function(settings) {
			
        }
	});
});