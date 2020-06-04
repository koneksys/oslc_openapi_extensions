
export const OSLCResourceShapePlugin = {
  wrapComponents: {
    Model: (OriginalComponent, system) => (props) => {
      const React = system.React;
      let expanded = true;
      const toggleCollapsed = ()=>{
        if(props.onToggle){
          props.onToggle(props.name,!expanded)
        }
        expanded = !expanded;
      }

      const properties = props.schema.get("properties");
      if(properties === undefined){ return null; }
      return (
        <div className="model-box">
          <span className="model">
            <span>
              { props.name && 
                <span onClick={toggleCollapsed} style={{ "cursor": "pointer" }}>
                  <span className="model-title">
                    <span className="model-title__text">  
                      Shape: "{props.name} Resource Shape"
                    </span>
                  </span>
                </span> }
              <span onClick={ toggleCollapsed } style={{ "cursor": "pointer" }}>
                <span className={ "model-toggle" + ( expanded ? "" : " collapsed" ) }></span>
              </span>
            </span>
          </span>
          <table>
              <thead>
                <tr>
                  <th>Prefixed Name</th>
                  <th>Occurs</th>
                  <th>Read-only</th>
                  <th>Value-type</th>
                  <th>Representation</th>
                  <th>Range</th>
                </tr>
              </thead>
              <tbody>
                {properties.entrySeq().map( ([key, value]) => 
                  <tr key={key}>
                    <td>{key}</td>
                    <td>{value.get('x-OSLC-Occurs')}</td>
                    <td>{value.get('x-OSLC-ReadOnly')}</td>
                    <td>{value.get('x-OSLC-ValueType')}</td>
                    <td>{value.get('x-OSLC-Representation')}</td>
                    <td>{value.get('x-OSLC-Range') ? value.get('x-OSLC-Range').map((item, index) => {
                      return (<div key={index}>{item}</div>)
                    }) : ""}</td>
                  </tr>
                  
                )}
              </tbody>
          </table>
        </div>
      )
    }
  }
}

export const OSLCEndpointPlugin = {
  wrapComponents: {
    OperationContainer: (OriginalComponent, system) => (props) => {
      console.log(props);
      const React = system.React;
      return (
        <div>
          {
            props.op.getIn(["operation","x-OSLC-ServiceProviderCatalog"]) &&
            <div>Service Provider Catalog</div>
          }
          {
            props.op.getIn(["operation","x-OSLC-CreationFactory"]) &&
            <div>Creation Factory</div>
          }
          {
            props.op.getIn(["operation","x-OSLC-QueryCapability"]) &&
            <div>Query Capability</div>
          }
        <OriginalComponent {...props}>
          {props.children}
        </OriginalComponent>
        </div>
      )
    }
  }
}
