package topLevelDomain.secondLevelDomain.homeneeds.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import topLevelDomain.secondLevelDomain.homeneeds.core.models.HomeDevice;
import topLevelDomain.secondLevelDomain.homeneeds.core.repositories.homeDevice.HomeDeviceRepository;

import java.net.URI;

@Controller
@RequestMapping("/home-device/")
public class HomeDeviceController {
  private HomeDeviceRepository homeDeviceRepository;

  @Autowired
  public HomeDeviceController(final HomeDeviceRepository homeDeviceRepository) {
    this.homeDeviceRepository = homeDeviceRepository;
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<HomeDevice> write(@RequestBody HomeDevice newHomeDevice) {
    HomeDevice createdHomeDevice = homeDeviceRepository.addNewHomeDevice(newHomeDevice);
    URI location = UriComponentsBuilder.fromPath("/home-device/")
      .path(String.valueOf(createdHomeDevice.getId()))
      .build().toUri();
    return ResponseEntity.created(location).body(createdHomeDevice);
  }
}
