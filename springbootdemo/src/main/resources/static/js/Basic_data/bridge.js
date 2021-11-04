/**
 * Created by new on 2017/5/22.
 */
$(document).ready(function () {

    $.jgrid.defaults.styleUI = 'Bootstrap';
    var mydata = [
        {
            
            name: "馒头",
            phone: "15027896686",
            cardId: "000001",
            operation: "<button>充值</button><button>消费</button>"
        }

    ];
    $("#table_list_2").jqGrid({
        data: mydata,
        datatype: "local",
        height: 450,
        autowidth: true,
        shrinkToFit: true,
        rowNum: 20,
        rowList: [10, 20, 30],
        colNames: ["姓名","手机号","卡号","操作"],
        colModel: [
           
            {
                name: 'name',
                index: 'name',
                editable: true,
                width: 40,
                align: "center"
            },
			{
			    name: 'phone',
			    index: 'phone',
			    editable: true,
			    width: 40,
			    align: "center"
			},
			{
			    name: 'cardId',
			    index: 'cardId',
			    editable: true,
			    width: 40,
			    align: "center"
			},
			{
			    name: 'operation',
			    index: 'operation',
			    editable: true,
			    width: 40,
			    align: "center"
			}
           
        ],
        pager: "#pager_list_2",
        viewrecords: true,
        caption: "会员信息",
        add: true,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false
    });

    // Add selection
    $("#table_list_2").setSelection(4, true);


    // Setup buttons
    $("#table_list_2").jqGrid('navGrid', '#pager_list_2', {
        edit: true,
        add: true,
        del: true,
        search: true
    }, {
        height: 200,
        reloadAfterSubmit: true
    });

    // Add responsive to jqGrid
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#table_list_2').setGridWidth(width);
    });
});