actorStore = new Ext.data.JsonStore({
		autoDestroy : true,
		remoteSort: true,
		totalProperty:'page.totalElements',
		storeId : 'myStore',
		idProperty : 'actor_id',
		root : 'page.content',
        writer: {
            type: 'json',
            writeAllFields: false,
        },
		proxy : new Ext.data.HttpProxy({
			method : 'POST',
			type : 'ajax',
			api:{
		        read : 'app/actor/select.json',
		        create : 'app/actor/create',
		        update: 'app/actor/update',
		        destroy: 'app/actor/delete'
			}
		}),
		fields : [ {
			name : 'actor_id',
			type : 'int'
		}, 'first_name', 'last_name', {
			name : 'last_update',
			type : 'date'
		} ]		
	});