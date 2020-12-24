<template>
  <div class="email">
    <v-card hover>
      <v-card-text>
        <p class="body-1">subject:</p>
        <p class="display-2 text--primary">
          el·ee·mos·y·nar·y
        </p>
        <p class="body-1">sender:</p>
        <p class="subtitle-2 text--primary">
          el·ee·mos·y·nar·y
        </p>
        <p class="body-1">recievers:</p>
        <p class="subtitle-2 text--primary">
          el·ee·mos·y·nar·y
        </p>

        <p class="body-1">body:</p>
        <div class="display-1 text--primary">
          relating to or dependent on charity; charitable.<br />
          "an eleemosynary educational institution."
        </div>
        <br />
        <p class="body-1" v-if="att.length > 0">attatchments:</p>

        <v-card hover style="width:400px" v-if="att.length > 0">
          <v-list flat>
            <v-list-item-group v-model="selectedItem" color="primary">
              <v-list-item v-for="(item, i) in items" :key="i">
                <v-list-item-content>
                  <v-list-item-title
                    v-text="item"
                    @click="openatt()"
                  ></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-card>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
// import axios from "axios";

export default {
  name: "email",
  props: ["selectedEmail"],
  components: {},
  mounted() {},
  methods: {
    openatt() {
      // var nn=this.items[this.selectedItem];
      // fetch("http://localhost:8089/download"+nn)
      // .then((r) => r.blob())
      // .then(function(data) {
      //   // let filename = needjson ? "canvas.json" : "canvas.xml";
      //   // if (window.navigator.msSaveOrOpenBlob) {
      //   //   window.navigator.msSaveBlob(data, filename);
      //   // } else {
      //   var elem = window.document.createElement("a");
      //   elem.href = window.URL.createObjectURL(data);
      //   elem.download = nn;
      //   document.body.appendChild(elem);
      //   elem.click();
      //   document.body.removeChild(elem);
      //   //}
      // });
    },
  },
  data: () => ({
    selectedItem: -1,

    items: ["srf", "ddd", "dd"],

    //
  }),
};
</script>
<style scoped>
.email {
  margin-top: 50px;
  margin-left: 300px;
  padding-left: 40px;
  width: 900px;
}
</style>
