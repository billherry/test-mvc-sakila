//Ext.ns('App.Grids');

var pageSize = 10;
var actorGrid = new Ext.grid.GridPanel({
	region:'center',
	plugins: [actorFilter],
	store : actorStore,
	colModel : new Ext.grid.ColumnModel({
		defaults : {
			width : 100,
			sortable : true
		},
		columns : [ {
			id : 'actorId',
			header : 'ID',
			width : 30,
			sortable : true,
			dataIndex : 'actorId'
		}, {
			header : 'First Name',
			dataIndex : 'firstName'
		}, {
			header : 'Last Name',
			dataIndex : 'lastName'
		}, {
			header : 'Last Updated',
			dataIndex : 'lastUpdate',
			xtype : 'datecolumn',
			format : 'Y.M.d'
		},{
			xtype : 'actioncolumn',
			items : [{
				icon : 'images/modify.png',
				tooltip : 'Edit',
				handler : function(grid, rowIndex, colIndex) {
					var rec = actorStore.getAt(rowIndex);
					actorForm.setRecord(rec);
				}
			},{
				icon : 'images/cross.png',
				tooltip : 'Delete',
				handler : function(grid, rowIndex, colIndex) {
					var rec = actorStore.getAt(rowIndex);
					actorStore.remove(rec);
				}
			}]
		}]
	}),
	bbar : new Ext.PagingToolbar({
		store : actorStore,
		displayInfo : true,
		pageSize : pageSize,
		prependButtons : true,
		plugins: [actorFilter],
	}),
	width : 350,
	height : 300,
	frame : false,
	title : 'Actors form sakila'
});
actorGrid.getBottomToolbar().doRefresh();