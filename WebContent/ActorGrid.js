Ext.ns('App', 'App.user');

App.user.Grid = Ext.extend(Ext.grid.EditorGridPanel,
				{
					renderTo : 'user-grid',
					iconCls : 'silk-grid',
					frame : true,
					title : 'Actors',
					height : 300,
					width : 500,
					style : 'margin-top: 10px',

					initComponent : function() {

						this.viewConfig = {
							forceFit : true
						};
						this.relayEvents(this.store, [ 'destroy', 'save',
								'update' ]);

						// build toolbars and buttons.
						this.tbar = this.buildTopToolbar();
						this.bbar = this.buildBottomToolbar();
						this.buttons = this.buildUI();

						// super
						App.user.Grid.superclass.initComponent.call(this);
					},

					/**
					 * buildTopToolbar
					 */
					buildTopToolbar : function() {
						return [ {
							text : 'Add',
							iconCls : 'silk-add',
							handler : this.onAdd,
							scope : this
						}, '-', {
							text : 'Delete',
							iconCls : 'silk-delete',
							handler : this.onDelete,
							scope : this
						}, '-' ];
					},

					/**
					 * buildBottomToolbar
					 */
					buildBottomToolbar : function() {
						return new Ext.PagingToolbar({
							store : this.store,
							displayInfo : true,
							pageSize : pageSize,
							prependButtons : true,
							plugins: [actorFilter],
						});
					},
					buildUI : function() {
						return [ {
							text : 'Save',
							iconCls : 'icon-save',
							handler : this.onSave,
							scope : this
						} ];
					},
					onSave : function(btn, ev) {
						this.store.save();
					},
					onAdd : function(btn, ev) {
						var u = new this.store.recordType({
							first : '',
							last : '',
							email : ''
						});
						this.stopEditing();
						this.store.insert(0, u);
						this.startEditing(0, 1);
					},
					onDelete : function(btn, ev) {
						var index = this.getSelectionModel().getSelectedCell();
						if (!index) {
							return false;
						}
						var rec = this.store.getAt(index[0]);
						this.store.remove(rec);
					}
				});