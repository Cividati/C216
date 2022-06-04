// const mqtt = require('mqtt')
import mqtt from 'mqtt';
const client  = mqtt.connect('mqtt://localhost:1883')

client.subscribe('sensor')

client.on('message', function (topic, message) {

  console.log(message.toString())

})