

describe('Registrar Usuario', () => {
  beforeEach('Acesse o site AluraPic', () => {
    cy.visit("https://alura-fotos.herokuapp.com/#/home")
  })

  it('Verificar mensagens de validação', () => {
    cy.contains('a', 'Register now').click();
    cy.contains('button', 'Register').click();
    cy.contains('ap-vmessage', 'Email is required').should('be.visible');
    cy.contains('button', 'Register').click();
    cy.contains('ap-vmessage', 'Full name is required').should('be.visible');
    cy.contains('ap-vmessage', 'User name is required').should('be.visible');
    cy.contains('ap-vmessage', 'Password is required').should('be.visible');
  })

  it('Verificar mensagem Invalid Email', () => {
    cy.contains('a', 'Register now').click();
    cy.contains('button', 'Register').click();
    cy.contains('ap-vmessage', 'Email is required').should('be.visible');
    cy.get('input[formcontrolname="email"]').type('testeteste');
    cy.contains('ap-vmessage', 'Invalid e-mail').should('be.visible');
  })

  it('Verificar o mínimo de caracteres no campo nome completo', () => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="fullName"]').type('h');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Mininum length is 2').should('be.visible');
  })

  it.only('Verificar o maximo de caracteres no campo nome completo',() => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="fullName"]').type('utchormormesuphystensistiotaterselsebleth');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Maximun length is 40').should('be.visible');
  })

  it('Verificar alert campo vazio em nome completo', () => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="fullName"]').type('h');
    cy.get('input[formcontrolname="fullName"]').clear();
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Full name is required!').should('be.visible');
  })

  it('Verificar o mínimo de caracteres no campo nome de usuario',() => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="userName"]').type('h');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Mininum length is 2').should('be.visible');
  })

  it('Verificar o maximo de caracteres no campo nome de usuário',() => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="userName"]').type('nteousewaterbeloweatricaltywenf');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Maximun length is 30').should('be.visible');
  })
  it('Verificar o caixa alta no campo nome de usuário',() => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="userName"]').type('nteousewaterbeloweatriltyweAA');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Must be lower case').should('be.visible');
  })

  it('Verificar alert campo vazio em nome de usuario', () => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="userName"]').type('h');
    cy.get('input[formcontrolname="userName"]').clear();
    cy.contains('button', 'Register').click();
    cy.contains('ap-vmessage', 'User name is required!').should('be.visible');
  })

  it('Verificar o mínimo de caracteres no campo senha',() => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="password"]').type('h');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Mininum length is 8').should('be.visible');
  })

  it('Verificar o maximo de caracteres no campo senha',() => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="password"]').type('uMVENtatomPTImEgRa');
    cy.get('.text-center').click();
    cy.contains('ap-vmessage', 'Maximun length is 18').should('be.visible');
  })

  it('Verificar alert campo vazio em senha de usuario', () => {
    cy.contains('a', 'Register now').click();
    cy.get('input[formcontrolname="password"]').type('h');
    cy.get('input[formcontrolname="password"]').clear();
    cy.contains('button', 'Register').click();
    cy.contains('ap-vmessage', 'Password is required!').should('be.visible');
  })

})