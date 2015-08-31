<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

        <div id="list-book" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${bookList}" displayStyle="table table-striped table-bordered table-hover" />

            <div  style="text-align: center;">
                <ul class="pagination pagination-sm">
                    <li><g:paginate total="${bookCount ?: 0}" /></li>
                </ul>
            </div>
        </div>
    </body>
</html>