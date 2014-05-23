actorForm = new Ext.form.FormPanel({
	title : 'Edit Actors',
	id : 'edit-form',
	load:({add:true}),
	layout : 'form',
	region : 'east',
	split : true,
	width : 285,
	record : null,
	buttons : [ {
		xtype : 'button',
		text : 'Modify',
		handler : function() {
			if (actorForm.getForm().isValid()) {
				actorForm.getForm().updateRecord(actorForm.record);
			}
			actorForm.getForm().reset();
			actorGrid.getBottomToolbar().doRefresh();
		},
		scope : this
	}, {
		xtype : 'button',
		text : 'New',
		handler : function() {
			actorForm.onCreate();
		},
		scope : this
	}  ],
	items : [ {
		layout : 'form',
		items : [ {
			xtype : 'fieldset',
			defaultType : 'textfield',
			items : [ {
				xtype : 'numberfield',
				name : 'actorId',
				fieldLabel : 'Id'
			}, {
				fieldLabel : 'FirstName',
				name : 'firstName'

			}, {
				fieldLabel : 'LastName',
				name : 'lastName'
			}, {
				xtype : 'datefield',
				fieldLabel : 'LastUpdate',
				name : 'lastUpdate',
				format : 'Y.M.d'
			} ]
		} ]
	} ],
	onCreate : function(btn,ev){
		if(!actorForm.getForm().isValid()){
			return false;
		}
		actorForm.fireEvent('create',actorForm,actorForm.getForm().getValues());
		actorForm.getForm().reset();
	}
});
