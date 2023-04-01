describe('Logar usuario',()=>{
    beforeEach('Acesse o site AluraPic', () => {
        cy.visit("https://alura-fotos.herokuapp.com/#/home")
    })

    it('Verificar mensagens de validação', () => {
        cy.contains('ap-vmessage', 'User name is required').should('be.visible');
        cy.contains('ap-vmessage', 'Password is required').should('be.visible');
    })

    it('Verificar o alerta de erro na senha ou usuario',() => {
        cy.get('input[formcontrolname="userName"]').type('h');
        cy.get('input[formcontrolname="password"]').type('h');
        cy.on('window:alert', (alertText) => {
            expect(alertText).to.contain('Invalid user name or password');
        });
        cy.get('.btn').click();
    })


})