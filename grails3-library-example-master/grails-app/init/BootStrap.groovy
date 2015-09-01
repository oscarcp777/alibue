import auth.Role
import auth.User
import auth.UserRole
import library.Author
import library.Book

import alibue.PollosTrozados
import alibue.PollosEnteros

class BootStrap {

    def init = { servletContext ->

        Author author1 = new Author(name:'Philip K',surname:'Dick')
        def books1 = [new Book(title: 'The Man in the High Castle', genre:Book.genres[3], releaseDate: Date.parse("yyyy", "1962")),
                      new Book(title: 'The Three Stigmata of Palmer Eldritch', genre:Book.genres[3], releaseDate: Date.parse("yyyy", "1965")),
                      new Book(title: 'Flow My Tears, the Policeman Said', genre:Book.genres[3], releaseDate: Date.parse("yyyy", "1974")),
                      new Book(title: 'Do Androids Dream of Electric Sheep?', genre:Book.genres[3], releaseDate: Date.parse("yyyy", "1968")),
                      new Book(title: 'A Scanner Darkly', genre:Book.genres[3], releaseDate: Date.parse("yyyy", "1977")),
                      new Book(title: 'VALIS', genre:Book.genres[3], releaseDate: Date.parse("yyyy", "1980"))
        ]
        books1.each {Book b -> author1.addToBooks(b)}
        author1.save flush:true, failOnError: true

        Author author2 = new Author(name:'Stephen',surname:'King')
        def books2 = [new Book(title: 'Carrie', genre:Book.genres[2], releaseDate: Date.parse("yyyy", "1974")),
                      new Book(title: 'Salem\'s Lot', genre:Book.genres[2], releaseDate: Date.parse("yyyy", "1975")),
                      new Book(title: 'The Shining', genre:Book.genres[2], releaseDate: Date.parse("yyyy", "1977")),
                      new Book(title: 'The Dead Zone', genre:Book.genres[2], releaseDate: Date.parse("yyyy", "1979")),
                      new Book(title: 'Misery', genre:Book.genres[2], releaseDate: Date.parse("yyyy", "1987"))
        ]
        books2.each {Book b -> author2.addToBooks(b)}
        author2.save flush:true, failOnError: true

        //auth init
        def adminRole = new Role(authority: 'ROLE_ADMIN').save flush: true, failOnError: true
        def userRole = new Role(authority: 'ROLE_USER').save flush: true, failOnError: true

        def testUser = new User(username: 'admin', password: 'admin')
        testUser.save flush: true, failOnError: true

        print testUser
        UserRole.create(testUser, adminRole, true)

        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1

        PollosEnteros enteros=new PollosEnteros(fecha:new Date(),cliente:'TRONCHIN', calibre:'6', nroInicio:1234, nroFin:1290, cantidad:20021)
        PollosEnteros enteros1=new PollosEnteros(fecha:new Date(),cliente:'COCUSO', calibre:'7', nroInicio:1234, nroFin:1290, cantidad:30021)
        PollosEnteros enteros2=new PollosEnteros(fecha:new Date(),cliente:'COCUSO', calibre:'7', nroInicio:1234, nroFin:1290, cantidad:40021)
        PollosEnteros enteros3=new PollosEnteros(fecha:new Date(),cliente:'ABALLAY', calibre:'8', nroInicio:2234, nroFin:2290, cantidad:50021)
        PollosEnteros enteros4=new PollosEnteros(fecha:new Date(),cliente:'Juan Perez', calibre:'9', nroInicio:1234, nroFin:1290, cantidad:60021)
        PollosEnteros enteros5=new PollosEnteros(fecha:new Date(),cliente:'Cresta Roja', calibre:'10', nroInicio:3234, nroFin:3290, cantidad:70021)
        PollosEnteros enteros6=new PollosEnteros(fecha:new Date(),cliente:'Alibue', calibre:'11', nroInicio:1234, nroFin:1290, cantidad:80021)
        PollosEnteros enteros7=new PollosEnteros(fecha:new Date(),cliente:'Alas', calibre:'6', nroInicio:1234, nroFin:1290, cantidad:90021)
        PollosEnteros enteros8=new PollosEnteros(fecha:new Date(),cliente:'Cresta Roja', calibre:'7', nroInicio:1234, nroFin:1290, cantidad:12021)
        PollosEnteros enteros9=new PollosEnteros(fecha:new Date(),cliente:'Puro Pecho', calibre:'8', nroInicio:1234, nroFin:1290, cantidad:34021)
        PollosEnteros enteros10=new PollosEnteros(fecha:new Date(),cliente:'Pura Ala', calibre:'9', nroInicio:1234, nroFin:1290, cantidad:11021)
        PollosEnteros enteros11=new PollosEnteros(fecha:new Date(),cliente:'Cresta azul', calibre:'10', nroInicio:1234, nroFin:1290, cantidad:12021)


        enteros.save flush:true, failOnError: true
        enteros1.save flush:true, failOnError: true
        enteros2.save flush:true, failOnError: true
        enteros3.save flush:true, failOnError: true
        enteros4.save flush:true, failOnError: true
        enteros5.save flush:true, failOnError: true
        enteros6.save flush:true, failOnError: true
        enteros7.save flush:true, failOnError: true
        enteros8.save flush:true, failOnError: true
        enteros9.save flush:true, failOnError: true
        enteros10.save flush:true, failOnError: true
        enteros11.save flush:true, failOnError: true

        PollosTrozados trozados=new PollosTrozados(fecha:new Date(),cliente:'TRONCHIN', producto:'Pecho', nroInicio:1234, nroFin:1290, cantidad:20021)
        PollosTrozados trozados1=new PollosTrozados(fecha:new Date(),cliente:'COCUSO', producto:'Alas', nroInicio:1234, nroFin:1290, cantidad:30021)
        PollosTrozados trozados2=new PollosTrozados(fecha:new Date(),cliente:'COCUSO', producto:'pecho premuin', nroInicio:1234, nroFin:1290, cantidad:40021)
        PollosTrozados trozados3=new PollosTrozados(fecha:new Date(),cliente:'ABALLAY', producto:'Alitas', nroInicio:2234, nroFin:2290, cantidad:50021)
        PollosTrozados trozados4=new PollosTrozados(fecha:new Date(),cliente:'Juan Perez', producto:'Cuello', nroInicio:1234, nroFin:1290, cantidad:60021)
        PollosTrozados trozados5=new PollosTrozados(fecha:new Date(),cliente:'Cresta Roja', producto:'Pechuga', nroInicio:3234, nroFin:3290, cantidad:70021)
        PollosTrozados trozados6=new PollosTrozados(fecha:new Date(),cliente:'Alibue', producto:'Supremas', nroInicio:1234, nroFin:1290, cantidad:80021)
        PollosTrozados trozados7=new PollosTrozados(fecha:new Date(),cliente:'Alas', producto:'Huesos', nroInicio:1234, nroFin:1290, cantidad:90021)
        PollosTrozados trozados8=new PollosTrozados(fecha:new Date(),cliente:'Cresta Roja', producto:'Pechuga', nroInicio:1234, nroFin:1290, cantidad:12021)
        PollosTrozados trozados9=new PollosTrozados(fecha:new Date(),cliente:'Puro Pecho', producto:'Pechuga', nroInicio:1234, nroFin:1290, cantidad:34021)
        PollosTrozados trozados10=new PollosTrozados(fecha:new Date(),cliente:'Pura Ala', producto:'Pechuga', nroInicio:1234, nroFin:1290, cantidad:11021)
        PollosTrozados trozados11=new PollosTrozados(fecha:new Date(),cliente:'Cresta azul', producto:'Pechuga', nroInicio:1234, nroFin:1290, cantidad:12021)


        trozados.save flush:true, failOnError: true
        trozados1.save flush:true, failOnError: true
        trozados2.save flush:true, failOnError: true
        trozados3.save flush:true, failOnError: true
        trozados4.save flush:true, failOnError: true
        trozados5.save flush:true, failOnError: true
        trozados6.save flush:true, failOnError: true
        trozados7.save flush:true, failOnError: true
        trozados8.save flush:true, failOnError: true
        trozados9.save flush:true, failOnError: true
        trozados10.save flush:true, failOnError: true
        trozados11.save flush:true, failOnError: true
    }
    def destroy = {
    }
}