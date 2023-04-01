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

    it.only('Verificar mensagem de erro na descrição',()=>{
        cy.get('input[formcontrolname="userName"]').type('weu1');
        cy.get('input[formcontrolname="password"]').type('123456789');
        cy.get('.btn').click();
        cy.get(':nth-child(2) > a > .fa').click();
        cy.get('input[type="file"]').then(subject => {
            cy.wrap(subject).trigger('click').then(() => {
                cy.get('body').type('{esc}')
            })
        })

    });
})