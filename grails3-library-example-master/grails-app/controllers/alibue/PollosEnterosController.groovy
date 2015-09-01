package alibue

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PollosEnterosController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PollosEnteros.list(params), model:[pollosEnterosCount: PollosEnteros.count()]
    }

    def show(PollosEnteros pollosEnteros) {
        respond pollosEnteros
    }

    def create() {
        respond new PollosEnteros(params)
    }

    @Transactional
    def save(PollosEnteros pollosEnteros) {
        if (pollosEnteros == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pollosEnteros.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pollosEnteros.errors, view:'create'
            return
        }

        pollosEnteros.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pollosEnteros.label', default: 'PollosEnteros'), pollosEnteros.id])
                redirect pollosEnteros
            }
            '*' { respond pollosEnteros, [status: CREATED] }
        }
    }

    def edit(PollosEnteros pollosEnteros) {
        respond pollosEnteros
    }

    @Transactional
    def update(PollosEnteros pollosEnteros) {
        if (pollosEnteros == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pollosEnteros.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pollosEnteros.errors, view:'edit'
            return
        }

        pollosEnteros.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pollosEnteros.label', default: 'PollosEnteros'), pollosEnteros.id])
                redirect pollosEnteros
            }
            '*'{ respond pollosEnteros, [status: OK] }
        }
    }

    @Transactional
    def delete(PollosEnteros pollosEnteros) {

        if (pollosEnteros == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pollosEnteros.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pollosEnteros.label', default: 'PollosEnteros'), pollosEnteros.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pollosEnteros.label', default: 'PollosEnteros'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
