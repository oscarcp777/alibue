<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'pollosEnteros.label', default: 'PollosEnteros')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
         <div class="nav" role="navigation">
            <ul
                <li><g:link class="btn btn-info" action="create"> Alta de Enteros</g:link></li>
            </ul>
        </div>
        <div id="list-pollosEnteros" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${pollosEnterosList}" />


            <div  style="text-align: center;">
                <ul class="pagination pagination-sm">
                    <li><g:paginate total="${pollosEnterosCount ?: 0}" /></li>
                </ul>
            </div>
        </div>
    </body>
</html>