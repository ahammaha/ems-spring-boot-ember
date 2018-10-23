import DS from 'ember-data';

export default DS.JSONSerializer.extend(DS.EmbeddedRecordsMixin, {
  attrs: {
    empdetails: {
      serialize: 'records',
      deserialize: 'records'
    }
  }
});