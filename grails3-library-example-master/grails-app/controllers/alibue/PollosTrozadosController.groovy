package alibue

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PollosTrozadosController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PollosTrozados.list(params), model:[pollosTrozadosCount: PollosTrozados.count()]
    }

    def show(PollosTrozados pollosTrozados) {
        respond pollosTrozados
    }

    def create() {
        respond new PollosTrozados(params)
    }

    @Transactional
    def save(PollosTrozados pollosTrozados) {
        if (pollosTrozados == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pollosTrozados.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pollosTrozados.errors, view:'create'
            return
        }

        pollosTrozados.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pollosTrozados.label', default: 'PollosTrozados'), pollosTrozados.id])
                redirect pollosTrozados
            }
            '*' { respond pollosTrozados, [status: CREATED] }
        }
    }

    def edit(PollosTrozados pollosTrozados) {
        respond pollosTrozados
    }

    @Transactional
    def update(PollosTrozados pollosTrozados) {
        if (pollosTrozados == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (pollosTrozados.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pollosTrozados.errors, view:'edit'
            return
        }

        pollosTrozados.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pollosTrozados.label', default: 'PollosTrozados'), pollosTrozados.id])
                redirect pollosTrozados
            }
            '*'{ respond pollosTrozados, [status: OK] }
        }
    }

    @Transactional
    def delete(PollosTrozados pollosTrozados) {

        if (pollosTrozados == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        pollosTrozados.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pollosTrozados.label', default: 'PollosTrozados'), pollosTrozados.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pollosTrozados.label', default: 'PollosTrozados'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
