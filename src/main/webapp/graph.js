function drawGraph(dataset) {

    var nodes = new vis.DataSet();
    var edges = new vis.DataSet();
    nodes.update(dataset['nodes']);
    edges.update(dataset['edges']);
    var container = document.getElementById('mynetwork');
    var data = {
        nodes: nodes,
        edges: edges
    };
    var options = {
        groups:{
            useDefaultGroups: false,
            friends: {
                color:{
                    background:'#f4c262'
                }
            }
        },
        nodes:{
            borderWidth:0,
            borderWidthSelected:0,
            color: {
                border: '#f4adf2',
                background: '#f4adf2',
                highlight: {
                    border: '#f4adf2',
                    background: '#f4adf2'
                },
                hover: {
                    border: '#f4adf2',
                    background: '#f4adf2'
                }
            }
        }
    };
    var network = new vis.Network(container, data, options);
}

function showAll() {
    $.ajax({
        type:'POST',
        url:"graph",
        dataType:'json',
        success:function (data) {
            console.log(data['nodes']);
            console.log(data['edges']);
            drawGraph(data);
        },
        error:function (error) {
            alert('No search results!');
            console.log(error);
        }

    });
    return false;
}
$(function () {
    $('#graphSearch').submit(function(){
        $.ajax({
            type:'POST',
            url:'graph',
            data:$(this).serialize(),
            dataType:'json',
            success:function (data) {
                alert('show');
                console.log(data['nodes']);
                console.log(data['edges']);
                drawGraph(data);
            },
            error:function (error) {
                alert('No search results!');
                console.log(error);
            }
        });
        return false;
    });

})
