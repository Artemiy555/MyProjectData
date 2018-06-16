function personCreate(event) {
    jQuery.ajax({
        type: 'POST',
        url:  '/person/create',
        data: {
            name:    jQuery('#name').val(),
            surname: jQuery('#surname').val(),
            age:     jQuery('#age').val()
        },
        success: function (response) {
            event.preventDefault();
            jQuery('#name').val('');
            jQuery('#surname').val('');
            jQuery('#age').val('');
        }
    });
}

function createPersonsTable() {

}

