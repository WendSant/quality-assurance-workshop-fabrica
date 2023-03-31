
describe('buscar curso de java da alura', () => {
    beforeEach('Entrar no site da alura',()=>{
        cy.visit("https://www.alura.com.br");
    });
    it('Pesquisar curso java', () => {
        cy.get('#header-barraBusca-form-campoBusca').type("java");
        cy.get('.header-barraBusca-form-submit').click();
        cy.get(':nth-child(1) > .busca-resultado-link').click();
    })
})