describe('Testando dentro da plataforma',()=>{
    beforeEach('Acesse o site AluraPic', () => {
        cy.visit("https://alura-fotos.herokuapp.com/#/home")
    })

    it('Logar na plataforma',() => {
        cy.get('input[formcontrolname="userName"]').type('weu1');
        cy.get('input[formcontrolname="password"]').type('123456789');
        cy.get('.btn').click();
        cy.contains('a','Logout').should('be.visible');
    })

    //Esse teste é meio triste
    //Esse aqui tem um problema da tela abrir a janela de selecionar o arquivo e eu não consegui achar como fechar com cypress
    // it.skip('Verificar mensagem de erro na descrição',()=>{
    //     cy.get('input[formcontrolname="userName"]').type('weu1');
    //     cy.get('input[formcontrolname="password"]').type('123456789');
    //     cy.get('.btn').click();
    //     cy.get(':nth-child(2) > a > .fa').click();
    //     cy.wait(1000);
    //     cy.focused().type('{alt}{f4}')
    // });

    it('Verificar mensagem de maximo caracteres no comentário',()=>{
        cy.get('input[formcontrolname="userName"]').type('weu1');
        cy.get('input[formcontrolname="password"]').type('123456789');
        cy.get('.btn').click();
        cy.get(':nth-child(1) > :nth-child(1) > a > ap-card > .card > .card-block > ap-photo > .img-thumbnail').click();
        cy.get('textarea[formcontrolname="comment"]').type("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        cy.contains('ap-vmessage', 'Maximun size allowed is 300').should('be.visible');
    });

    //Nesse teste é preciso uma imagem upada no site para que ele possa apagar.
    it('Verificar mensagem de confirmação ao apagar',()=>{
        cy.get('input[formcontrolname="userName"]').type('weu1');
        cy.get('input[formcontrolname="password"]').type('123456789');
        cy.get('.btn').click();
        cy.get(':nth-child(1) > :nth-child(1) > a > ap-card > .card > .card-block > ap-photo > .img-thumbnail').click();
        cy.get('.fa-trash-o').click();
        cy.get('ap-alert > .text-center').should('contain', 'Photo removed');
    });

    //Como a pesquisa é dinamica só verifico se o input ta recebendo o texto, pois pode existir ou não uma foto.
    it('Verificar caixa de pesquisa',()=>{
        cy.get('input[formcontrolname="userName"]').type('weu1');
        cy.get('input[formcontrolname="password"]').type('123456789');
        cy.get('.btn').click();
       cy.get('input[type="search"]').type("teste");
        cy.get('input[type="search"]').should('have.value', 'teste');
    });

    it('Verificar se exibe comentários anteriores',()=>{
        cy.get('input[formcontrolname="userName"]').type('weu1');
        cy.get('input[formcontrolname="password"]').type('123456789');
        cy.get('.btn').click();
        cy.get(':nth-child(1) > :nth-child(1) > a > ap-card > .card > .card-block > ap-photo > .img-thumbnail').click();
        cy.get('ap-photo-comments > :nth-child(1) > .list-unstyled > li').should('be.visible');
    });



})