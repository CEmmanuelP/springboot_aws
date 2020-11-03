var main = {
    init : function (){
        var _this = this;
        $('#btn-save').on('click', function (){
            _this.save();
        });
    },
    init2 : function (){
        var _this = this;
        $('#btn-message').on('click', function (){
            _this.message();
        });
    },
    save : function (){
        var data = {
            loginId: $('#loginId').val(),
            password: $('#password').val(),
            name: $('#name').val(),
            token: $('#token').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/members',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('회원가입을 축하합니다.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    update : function (){
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: 'api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    delete : function (){
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (){
            alert('글이 삭제되었습니다');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    },
    message : function (){
        var data = {
            to: $('#to').val(),
            title: $('#title').val(),
            body: $('#body').val()
        };

        $.ajax({
            type: 'POST',
            url: '/message',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (){
            alert('Send Message.');
            window.location.href = '/';
        }).fail(function (error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();
main.init2();