function getMenuTree() {
    var root = {
        id : 0,
        name : "root",
        open : true,
    };

    $.ajax({
        type : 'get',
        url : '/classifications/all',
        contentType : "application/json; charset=utf-8",
        async : false,
        success : function(data) {
            var length = data.length;
            var children = [];
            for (var i = 0; i < length; i++) {
                var d = data[i];
                var node = createNode(d);
                children[i] = node;
            }

            root.children = children;
        }
    });

    return root;
}

function initTypeDatas(goodsId){
    $.ajax({
        type : 'get',
        url : '/goodsTypes?goodsId=' + goodsId,
        success : function(data) {
            var length = data.length;
            var ids = [];
            for(var i=0; i<length; i++){
                ids.push(data[i]['id']);
            }
            
            initTypeCheck(ids);
        }
    });
}

function initTypeCheck(ids) {
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var length = ids.length;
    if(length > 0){
        var node = treeObj.getNodeByParam("id", 0, null);
        treeObj.checkNode(node, true, false);
    }
    
    for(var i=0; i<length; i++){
        var node = treeObj.getNodeByParam("id", ids[i], null);
        treeObj.checkNode(node, true, false);
    }
    
}

function getCheckedTypeIds(){
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var nodes = treeObj.getCheckedNodes(true);
    
    var length = nodes.length;
    var ids = [];
    for(var i=0; i<length; i++){
        var n = nodes[i];
        var id = n['id'];
        ids.push(id);
    }
    
    return ids;
}

function createNode(d) {
    var id = d['id'];
    var pId = d['pid'];
    var name = d['name'];
    var child = d['child'];

    var node = {
        open : true,
        id : id,
        name : name,
        pId : pId,
    };

    if (child != null) {
        var length = child.length;
        if (length > 0) {
            var children = [];
            for (var i = 0; i < length; i++) {
                children[i] = createNode(child[i]);
            }

            node.children = children;
        }

    }
    return node;
}

 

function getSettting() {
    var setting = {
        check : {
            enable : true,
//            chkStyle: "radio",  //单选框
//            radioType: "level",
            chkboxType : {
                "Y" : "ps",
                "N" : "ps"
            }
        },
        async : {
            enable : true,
        },
        data : {
            simpleData : {
                enable : true,
                idKey : "id",
                pIdKey : "pId",
                rootPId : 0
            }
        },
        callback : {
            onClick : zTreeOnClick
        }
    };

    return setting;
}

function zTreeOnClick(event, treeId, treeNode) {
//  console.log(treeNode.id + ", " + treeNode.name + "," + treeNode.checked
//          + "," + treeNode.pId);
//  console.log(JSON.stringify(treeNode));
    
//    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
//    treeObj.checkNode(treeNode, true, false);
}