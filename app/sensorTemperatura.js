export class sensorTemperatura {

    getTemperatura(){
        return Math.floor(Math.random() * 100);
    }
    constructor(altura, largura) {
      this.altura = altura;
      this.largura = largura;
    }
  }